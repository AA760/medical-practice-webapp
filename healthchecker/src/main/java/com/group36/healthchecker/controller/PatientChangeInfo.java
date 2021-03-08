package com.group36.healthchecker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.group36.healthchecker.repository.PatientRepository2;
import com.group36.healthchecker.model.Patient2;


@RestController
@RequestMapping("/")
public class PatientChangeInfo 
{
	@Autowired
	private PatientRepository2 patientRepository2;
	
	
	//Get all patients
	@GetMapping("/patients")
	public List<Object[]> getAllUsers(){
		return patientRepository2.findPatients();
	}
	
	//Change info by ID
	@PutMapping("/changePatientInfo")
	public Patient2 update(@RequestBody Patient2 patient2)
	{
	return patientRepository2.save(patient2);
	}
	

	
	

}