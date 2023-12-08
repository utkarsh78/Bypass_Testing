package com.example.bypasstesting.repositories;

import com.example.bypasstesting.entities.Bookings;
import com.example.bypasstesting.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingsRepo extends JpaRepository<Bookings, Integer> {
    @Query(value="SELECT * FROM bookings WHERE vehicle_reg_no=:vehicleRegNo",nativeQuery = true)
    List<Bookings> findAllBookingsByVehicleRegNo(String vehicleRegNo);

    @Query(value="SELECT * FROM bookings WHERE customer_id=:customerId AND out_date is null",nativeQuery = true)
    List<Bookings> findOngoingBookingsByCustomerId(Integer customerId);

    @Query(value="SELECT * FROM bookings WHERE customer_id=:customerId AND out_date is not null",nativeQuery = true)
    List<Bookings>findBookingsByOutDateAndCustomerId(Integer customerId);
}