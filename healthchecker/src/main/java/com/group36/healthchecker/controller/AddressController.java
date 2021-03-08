package com.group36.healthchecker.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.group36.healthchecker.model.Address;
import com.group36.healthchecker.repository.AddressRepository;


@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepository;
    
    @GetMapping("/address")
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @PostMapping("/address")
    public Address createAddress(@Valid @RequestBody Address address) {
    	return addressRepository.save(address);
    }

}
