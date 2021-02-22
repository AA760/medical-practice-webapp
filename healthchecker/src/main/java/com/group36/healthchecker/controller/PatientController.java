package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group36.healthchecker.model.Address;
import com.group36.healthchecker.model.Patient;
import com.group36.healthchecker.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	PatientRepository patientRepository;
	
	@GetMapping("/patient")
	public List<Patient> getPatient() {
		return patientRepository.findAll();
	}

	@PostMapping("/patient")
	public Patient createPatient(@Valid @RequestBody Patient patient) {

		AddressController addressController = new AddressController();
		Address address=new Address();

		return patientRepository.save(patient);
	}
}
