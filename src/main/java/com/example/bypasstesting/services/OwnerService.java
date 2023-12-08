package com.example.bypasstesting.services;

import com.example.bypasstesting.payloads.CustomerDto;
import com.example.bypasstesting.payloads.OwnerDto;

public interface OwnerService {
    OwnerDto registerOwner(OwnerDto ownerDto);

    OwnerDto loginOwner(String phone, String password);

    OwnerDto getOwnerByPhone(String phone);

}
