package com.example.bypasstesting.repositories;

import com.example.bypasstesting.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findCustomerByPhone(String phone);
}