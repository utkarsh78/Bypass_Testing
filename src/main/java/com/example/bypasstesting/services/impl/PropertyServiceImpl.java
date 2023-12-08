package com.example.bypasstesting.services.impl;

import com.example.bypasstesting.entities.Owner;
import com.example.bypasstesting.entities.Property;
import com.example.bypasstesting.exceptions.ResourceNotFoundException;
import com.example.bypasstesting.payloads.BookingsDto;
import com.example.bypasstesting.payloads.OwnerDto;
import com.example.bypasstesting.payloads.PropertyDto;
import com.example.bypasstesting.repositories.OwnerRepo;
import com.example.bypasstesting.repositories.PropertyRepo;
import com.example.bypasstesting.services.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private ModelMapper modelMapper;

    public PropertyDto registerProperty(PropertyDto propertyDto){
        Property property = this.modelMapper.map(propertyDto, Property.class);
        Property savedProperty = this.propertyRepo.save(property);
        return this.modelMapper.map(savedProperty, PropertyDto.class);
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto){
        Property property = this.propertyRepo.findById(propertyDto.getProp_id()).orElseThrow(()->new ResourceNotFoundException("Property", "Property ID", propertyDto.getProp_id()));
        property.setSlots(propertyDto.getSlots());
        property.setProp_address(propertyDto.getProp_address());
        property.setPincode(propertyDto.getPincode());
        Property updatedProperty = this.propertyRepo.save(property);
        return this.modelMapper.map(updatedProperty, PropertyDto.class);
    }

    public List<PropertyDto> searchProperty(Integer ownerId){
        List<Property> propertyFound = this.propertyRepo.findPropertyByOwnerId(ownerId);
        return propertyFound.stream().map(properties -> this.modelMapper.map(properties, PropertyDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteProperty(Integer prop_id) {
        Property property = this.propertyRepo.findById(prop_id).orElseThrow(() -> {
            return new ResourceNotFoundException("Property", "Property ID", prop_id);
        });
        this.propertyRepo.delete(property);
    }

    public List<PropertyDto> searchPropertyforCust(Integer pincode){
        List<Property> propertycust = this.propertyRepo.findPropertyByPincode(pincode);
        return propertycust.stream().map(properties -> this.modelMapper.map(properties, PropertyDto.class)).collect(Collectors.toList());
    }

}
