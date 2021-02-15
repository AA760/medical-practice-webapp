package com.group36.healthchecker.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group36.healthchecker.model.AppUserDetails;


@Controller
public class SecurityController 
{

	//returns username of currently logged in user
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Authentication authentication) 
	{
		return authentication.getName();
		
	}
	
	
	//returns id of currently logged in user
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	@ResponseBody
	public int currentId(Authentication authentication) 
	{
		
		AppUserDetails user2 = (AppUserDetails)authentication.getPrincipal();
		return user2.getId();
	}
	
	
	
	

}
