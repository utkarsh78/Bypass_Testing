package com.example.bypasstesting.services;

import com.example.bypasstesting.payloads.CustomerDto;

public interface CustomerService {
    CustomerDto registerCustomer(CustomerDto customerDto);

    CustomerDto loginCustomer(String phone, String password);

    CustomerDto getCustomerByPhone(String phone);
}