package com.example.bypasstesting.payloads;

import com.example.bypasstesting.entities.Property;
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
public class OwnerDto {
    private Integer ownerId;
    private String name;
    private String phone;
    private String address;
    private String password;
    private List<Property> propertyList;
}
