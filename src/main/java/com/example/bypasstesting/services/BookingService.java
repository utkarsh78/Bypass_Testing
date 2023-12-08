package com.example.bypasstesting.services;

import com.example.bypasstesting.payloads.BookingsDto;
import com.example.bypasstesting.payloads.CustomerDto;

import java.util.List;

public interface BookingService {
    BookingsDto newBooking(BookingsDto bookingsDto);
    List<BookingsDto> getBookingsByVehicleRegNo(String vehicleRegNo);
    List<BookingsDto> getOnGoingBooking(Integer customerId);
    BookingsDto goingOut(Integer bookingId, String price);

    List<BookingsDto> pastBookings(Integer customerId);
}
