package com.example.bypasstesting.controllers;


import com.example.bypasstesting.payloads.Credentials;
import com.example.bypasstesting.payloads.CustomerDto;
import com.example.bypasstesting.payloads.OwnerDto;
import com.example.bypasstesting.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
@CrossOrigin(origins = "*")

public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping("/")
    public ResponseEntity<OwnerDto> registerOwner(@RequestBody OwnerDto ownerDto) {
        OwnerDto registerOwnerDto = this.ownerService.registerOwner(ownerDto);
        return new ResponseEntity<>(registerOwnerDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<OwnerDto> loginOwner(@RequestBody Credentials credentials){
        OwnerDto ownerDto = this.ownerService.loginOwner(credentials.getPhone(), credentials.getPassword());
        if(ownerDto != null)
            return new ResponseEntity<>(ownerDto, HttpStatus.OK);
        return new ResponseEntity<>(ownerDto, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/getOwner/{phone}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable String phone) {
        return ResponseEntity.ok(this.ownerService.getOwnerByPhone(phone));
    }

}
