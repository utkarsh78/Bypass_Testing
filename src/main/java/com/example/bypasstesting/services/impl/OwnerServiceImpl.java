package com.example.bypasstesting.services.impl;

import com.example.bypasstesting.entities.Customer;
import com.example.bypasstesting.entities.Owner;
import com.example.bypasstesting.exceptions.ResourceNotFoundException;
import com.example.bypasstesting.payloads.CustomerDto;
import com.example.bypasstesting.payloads.OwnerDto;
import com.example.bypasstesting.repositories.CustomerRepo;
import com.example.bypasstesting.repositories.OwnerRepo;
import com.example.bypasstesting.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepo ownerRepo;
    @Autowired
    private ModelMapper modelMapper;

    public OwnerDto registerOwner(OwnerDto ownerDto){
        Owner owner = this.modelMapper.map(ownerDto, Owner.class);
        Owner savedOwner = this.ownerRepo.save(owner);
        return this.modelMapper.map(savedOwner, OwnerDto.class);
    }

    @Override
    public OwnerDto loginOwner(String phone, String password){
        Owner owner = this.ownerRepo.findOwnerByPhone(phone);
        if(owner == null)
            throw new ResourceNotFoundException("Owner", "Phone", 0);
        String pass = owner.getPassword();
        if(!password.equals(pass))
            throw new ResourceNotFoundException("Customer", "Password", 0);
        return this.modelMapper.map(owner, OwnerDto.class);
    }

    @Override
    public OwnerDto getOwnerByPhone(String phone){
        Owner owner = this.ownerRepo.findOwnerByPhone(phone);
        if(owner == null)
            throw new ResourceNotFoundException("Owner", "Phone", 0);
        return this.modelMapper.map(owner, OwnerDto.class);
    }
}
