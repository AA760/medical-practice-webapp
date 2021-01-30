package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.group36.healthchecker.exception.ResourceNotFoundException;

import com.group36.healthchecker.model.Users;

import com.group36.healthchecker.repository.UserRepository;

@RestController
//@RequestMapping("/")
public class UserController {

	@Autowired
	UserRepository userRepository;
	

	@Autowired

	// Get All Job Texts
	@GetMapping("/user")
	public List<Users> getUser() {
		return userRepository.findAll();
	}

	// Create a new Job Text
	@PostMapping("/user")
	public Users createUser(@Valid @RequestBody Users user) {
		return userRepository.save(user);
	}

}
