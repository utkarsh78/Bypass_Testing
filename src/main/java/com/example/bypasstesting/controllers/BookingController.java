package com.example.bypasstesting.controllers;

import com.example.bypasstesting.entities.Bookings;
import com.example.bypasstesting.entities.Property;
import com.example.bypasstesting.exceptions.ResourceNotFoundException;
import com.example.bypasstesting.payloads.*;
import com.example.bypasstesting.services.BookingService;
import com.example.bypasstesting.services.CustomerService;
import com.example.bypasstesting.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/newBooking")
    public ResponseEntity<BookingsDto> newBooking(@RequestBody BookingsDto bookingDto) {
        BookingsDto newBookingDto = this.bookingService.newBooking(bookingDto);
        return new ResponseEntity<>(newBookingDto, HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<List<BookingsDto>> getBookingByVehicle(@RequestBody VehicleRegNo vehicleRegNo){
        List<BookingsDto> bookingsDtoList = bookingService.getBookingsByVehicleRegNo(vehicleRegNo.getVehicle_reg_no());
        if(bookingsDtoList != null)
            return new ResponseEntity<>(bookingsDtoList, HttpStatus.OK);
        throw new ResourceNotFoundException("bookings", "VehicleRegNo", 0);
    }

    @PostMapping("/currentBooking")
    public ResponseEntity<List<BookingsDto>> getOngoingBookings(@RequestBody OngoingBooking ongoingBooking){
        List<BookingsDto> bookingsDtoList = bookingService.getOnGoingBooking(ongoingBooking.getCustomerId());
        return new ResponseEntity<>(bookingsDtoList, HttpStatus.OK);
    }

    @PutMapping("/out")
    public ResponseEntity<BookingsDto> goingOut(@RequestBody OutBooking outBooking){
        BookingsDto out = bookingService.goingOut(outBooking.getBookingId(), outBooking.getPrice());
        if(out != null)
            return new ResponseEntity<>(out, HttpStatus.OK);
        throw new ResourceNotFoundException("bookings", "goingOut", 0);
    }

    @PostMapping("/pastBooking")
    public ResponseEntity<List<BookingsDto>> pastBookings(@RequestBody OngoingBooking ongoingBooking){
        List<BookingsDto> bookingsDtoList = bookingService.pastBookings(ongoingBooking.getCustomerId());
        if(bookingsDtoList != null)
            return new ResponseEntity<>(bookingsDtoList, HttpStatus.OK);
        throw new ResourceNotFoundException("bookings", "pastBookings", 0);
    }
}