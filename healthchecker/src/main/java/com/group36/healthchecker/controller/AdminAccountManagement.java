  
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
import com.group36.healthchecker.model.User;
import com.group36.healthchecker.repository.UserRepository;

@RestController
@RequestMapping("/")
public class AdminAccountManagement 
{
	@Autowired
	private UserRepository userRepository;
	
	
	//Get all users
	@GetMapping("/users")
	public List<Object[]> getAllUsers(){
		return userRepository.findUsers();
	}
	
	//Create new user login
	@PostMapping("/createUser")
	public User save(@RequestBody User user)
	{
		return userRepository.save(user);
		
	}
	
	//Delete by username
	@DeleteMapping("/deleteUserName/{userName}")
	public String deleteUserName(@PathVariable String userName)
	{
		Optional<User> user = userRepository.findByUserName(userName);
		if(user.isPresent())
		{
			userRepository.delete(user.get());
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
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			userRepository.delete(user.get());
			return "Deletion successful for user: " +id;
		}
		
		else
		{
			throw new RuntimeException("Employee not found for id: " +id);
		}
		
	}
	
	//Change password by ID
	@PutMapping("/changePassword")
	public User update(@RequestBody User user)
	{
	return userRepository.save(user);
	}
	
	
	
	
	

}