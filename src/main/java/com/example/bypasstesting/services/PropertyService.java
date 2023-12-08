package com.example.bypasstesting.services;

import com.example.bypasstesting.payloads.OwnerDto;
import com.example.bypasstesting.payloads.PropertyDto;

import java.util.List;

public interface PropertyService {

    PropertyDto registerProperty(PropertyDto propertyDto);

    PropertyDto updateProperty(PropertyDto propertyDto);

    List<PropertyDto> searchProperty(Integer ownerId);

    List<PropertyDto> searchPropertyforCust(Integer pincode);

    void deleteProperty(Integer prop_id);

}
