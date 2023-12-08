package com.example.bypasstesting.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column(nullable = false)
    private String prop_address;

    @Column(nullable = false)
    private String vehicle_reg_no;

//    @Column(nullable = false)
    private Date in_date;

//    @Column(nullable = false)
    private Date out_date;

//    @Column(nullable = false)
    private String price;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="prop_id")
    private Property property;
}
