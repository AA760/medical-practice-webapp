package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.group36.healthchecker.model.Users;

import com.group36.healthchecker.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user")
	public List<Users> getUser() {
		return userRepository.findAll();
	}

	@PostMapping("/user")
	public Users createUser(@Valid @RequestBody Users user) {
		return userRepository.save(user);
	}

}
