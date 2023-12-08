package com.example.bypasstesting.payloads;

import com.example.bypasstesting.entities.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private Integer prop_id;
    private Integer slots;
    private String prop_address;
    private Integer pincode;
    private Owner owner;
}