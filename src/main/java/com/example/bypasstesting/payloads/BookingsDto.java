package com.example.bypasstesting.payloads;

import com.example.bypasstesting.entities.Customer;
import com.example.bypasstesting.entities.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingsDto {
    private Integer bookingId;
    private String prop_address;
    private String vehicle_reg_no;
    private Date in_date;
    private Date out_date;
    private String price;
    private Customer customer;
    private Property property;
}