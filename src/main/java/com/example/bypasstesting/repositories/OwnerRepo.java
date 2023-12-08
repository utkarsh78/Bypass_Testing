package com.example.bypasstesting.repositories;
import com.example.bypasstesting.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Integer>{
    Owner findOwnerByPhone(String phone);
}
