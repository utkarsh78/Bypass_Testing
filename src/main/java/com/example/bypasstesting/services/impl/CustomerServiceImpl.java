package com.example.bypasstesting.services.impl;

import com.example.bypasstesting.entities.Customer;
import com.example.bypasstesting.exceptions.GlobalExceptionHandler;
import com.example.bypasstesting.exceptions.ResourceNotFoundException;
import com.example.bypasstesting.payloads.CustomerDto;
import com.example.bypasstesting.repositories.CustomerRepo;
import com.example.bypasstesting.services.CustomerService;
import jakarta.persistence.OneToMany;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDto registerCustomer(CustomerDto customerDto){
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = this.customerRepo.save(customer);
        return this.modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto loginCustomer(String phone, String password){
        Customer customer = this.customerRepo.findCustomerByPhone(phone);
        if(customer == null)
            throw new ResourceNotFoundException("Customer", "Phone", 0);
        String pass = customer.getPassword();
        if(!password.equals(pass))
            throw new ResourceNotFoundException("Customer", "Password", 0);
        return this.modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerByPhone(String phone){
        Customer customer = this.customerRepo.findCustomerByPhone(phone);
        if(customer == null)
            throw new ResourceNotFoundException("Customer", "Phone", 0);
        return this.modelMapper.map(customer, CustomerDto.class);
    }
}
