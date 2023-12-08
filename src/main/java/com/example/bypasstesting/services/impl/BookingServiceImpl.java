package com.example.bypasstesting.services.impl;

import com.example.bypasstesting.entities.Bookings;
import com.example.bypasstesting.entities.Property;
import com.example.bypasstesting.exceptions.ResourceNotFoundException;
import com.example.bypasstesting.payloads.BookingsDto;
import com.example.bypasstesting.repositories.BookingsRepo;
import com.example.bypasstesting.repositories.PropertyRepo;
import com.example.bypasstesting.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingsRepo bookingsRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PropertyRepo propertyRepo;

    @Override
    public BookingsDto newBooking(BookingsDto bookingsDto){
        Bookings bookings = this.modelMapper.map(bookingsDto, Bookings.class);
        bookings.setIn_date(new Date());
//        System.out.println(bookingsDto.getv());
        Bookings createBooking = this.bookingsRepo.save(bookings);
        Property property = this.propertyRepo.findById(bookings.getProperty().getProp_id()).orElseThrow(() -> new ResourceNotFoundException("Booking", "Property", 0));
        if(property.getSlots() == 0)
            throw new ResourceNotFoundException("Booking", "Property", 0);
        property.setSlots(property.getSlots()-1);
        this.propertyRepo.save(property);
        return this.modelMapper.map(createBooking, BookingsDto.class);
    }

    @Override
    public List<BookingsDto> getBookingsByVehicleRegNo(String vehicleRegNo) {
        List<Bookings> bookingsList = bookingsRepo.findAllBookingsByVehicleRegNo(vehicleRegNo);
        return bookingsList.stream().map(bookings -> this.modelMapper.map(bookings, BookingsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookingsDto> getOnGoingBooking(Integer customerId){
        List<Bookings> bookingsList = bookingsRepo.findOngoingBookingsByCustomerId(customerId);
//        System.out.println(bookingsList.size());
        for(Bookings booking: bookingsList){
//            System.out.println("Hi" + booking.getCustomer().getCustomerId());
            Date curDate = new Date();
            Date inDate = booking.getIn_date();
            long difference = Math.abs(curDate.getTime() - inDate.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            long price = 50+50*differenceDates;
            booking.setPrice(Long.toString(price));
//            this.bookingsRepo.save(booking);
        }
        return bookingsList.stream().map(bookings -> this.modelMapper.map(bookings, BookingsDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingsDto goingOut(Integer bookingId, String price){
        Bookings booking = this.bookingsRepo.findById(bookingId).orElseThrow(()->new ReadOnlyFileSystemException());
        booking.setPrice(price);
        booking.setOut_date(new Date());
        Bookings updatedBooking = this.bookingsRepo.save(booking);
        Property property = booking.getProperty();
        property.setSlots(property.getSlots() + 1);
        this.propertyRepo.save(property);
        return this.modelMapper.map(updatedBooking, BookingsDto.class);
    }

    @Override
    public List<BookingsDto> pastBookings(Integer customerId){
        List<Bookings> bookingsList = this.bookingsRepo.findBookingsByOutDateAndCustomerId(customerId);
        return bookingsList.stream().map(bookings -> this.modelMapper.map(bookings, BookingsDto.class)).collect(Collectors.toList());
    }
}
