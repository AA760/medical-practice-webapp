package com.group36.healthchecker.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.group36.healthchecker.model.User2;
import com.group36.healthchecker.repository.UserRepository2;

@RestController
@RequestMapping("/")
public class AdminAccountManagement 
{
	@Autowired
	private UserRepository2 userRepository2;
	
	
	//Get all users
	@GetMapping("/users")
	public List<Object[]> getAllUsers(){
		return userRepository2.findUsers();
	}
	
	//Create new user login
	@PostMapping("/createUser")
	public User2 save(@RequestBody User2 user2)
	{
		return userRepository2.save(user2);
		
	}
	
	//Delete by username
	@DeleteMapping("/deleteUserName/{userName}")
	public String deleteUserName(@PathVariable String userName)
	{
		Optional<User2> user2 = userRepository2.findByUserName(userName);
		if(user2.isPresent())
		{
			userRepository2.delete(user2.get());
			return "Deletion successful for user: " +userName;
		}
		
		else
		{
			throw new RuntimeException("Employee not found for username: " +userName);
		}
		
	}
	
	//Delete by ID
	@DeleteMapping("/deleteId/{id}")
	public String deleteId(@PathVariable int id)
	{
		Optional<User2> user2 = userRepository2.findById(id);
		if(user2.isPresent())
		{
			userRepository2.delete(user2.get());
			return "Deletion successful for user: " +id;
		}
		
		else
		{
			throw new RuntimeException("Employee not found for id: " +id);
		}
		
	}
	
	//Change password by ID
	@PutMapping("/changePassword")
	public User2 update(@RequestBody User2 user2)
	{
	return userRepository2.save(user2);
	}
	

	
	

}