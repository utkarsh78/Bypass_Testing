package com.example.bypasstesting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;
}