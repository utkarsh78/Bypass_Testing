package com.example.bypasstesting.repositories;

import com.example.bypasstesting.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRepo extends JpaRepository<Property, Integer> {
    List<Property> findPropertyByPincode(Integer pincode);

    @Query(value="SELECT * FROM properties WHERE owner_id=:ownerId",nativeQuery = true)
    List<Property> findPropertyByOwnerId (Integer ownerId);
}
