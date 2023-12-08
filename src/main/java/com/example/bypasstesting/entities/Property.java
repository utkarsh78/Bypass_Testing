package com.example.bypasstesting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prop_id;

    @Column(nullable = false)
    private Integer slots;

    @Column(nullable = false)
    private String prop_address;

    @Column(nullable = false)
    private Integer pincode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ownerId")
    private Owner owner;
}