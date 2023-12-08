package com.example.bypasstesting.controllers;

import com.example.bypasstesting.exceptions.ResourceNotFoundException;
import com.example.bypasstesting.payloads.Credentials;
import com.example.bypasstesting.payloads.CustomerDto;
import com.example.bypasstesting.payloads.Phone;
import com.example.bypasstesting.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createCustomerDto = this.customerService.registerCustomer(customerDto);
        return new ResponseEntity<>(createCustomerDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDto> loginCustomer(@RequestBody Credentials credentials){
        CustomerDto customerDto = this.customerService.loginCustomer(credentials.getPhone(), credentials.getPassword());
        if(customerDto != null)
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        return new ResponseEntity<>(customerDto, HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("/getCustomer")
    public ResponseEntity<CustomerDto> getCustomerByPhone(@RequestBody Phone phone){
        CustomerDto customerDto = this.customerService.getCustomerByPhone(phone.getPhone());
        if(customerDto != null)
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        throw new ResourceNotFoundException("Customer", "Phone", 0);
    }
}