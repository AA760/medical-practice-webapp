package com.group36.healthchecker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI 
{
	
	//This is an example API endpoint which all users have access to
    @GetMapping("/")
    public String home() 
    {
        return ("<h1>Welcome to the homepage</h1>");
    }
    
    //This is an example API endpoint which patient and admin users have access to
    @GetMapping("/patient")
    public String patient() 
    {
        return ("<h1>Patient log-in successful</h1>");
    }
    
    //This is an example API endpoint which doctors and admin users have access to 
    @GetMapping("/doctor")
    public String doctor() 
    {
        return ("<h1>Doctor log-in successful</h1>");
    }
    
    //This is an example API endpoint which admin users have access to
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Admin log-in successful</h1>");
    }
}