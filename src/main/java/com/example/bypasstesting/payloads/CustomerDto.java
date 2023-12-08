package com.example.bypasstesting.payloads;

import com.example.bypasstesting.entities.Bookings;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer customerId;
    private String name;
    private String phone;
    private String address;
    private String pincode;
    private String password;
    private List<Bookings> bookingsList;
}
