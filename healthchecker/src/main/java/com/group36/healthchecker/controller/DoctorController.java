package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group36.healthchecker.model.Doctor;
import com.group36.healthchecker.repository.DoctorRepsitory;

@RestController
public class DoctorController {

	@Autowired
	DoctorRepsitory doctorRepository;

	@GetMapping("/doctor")
	public List<Doctor> getDoctor() {
		return doctorRepository.findAll();
	}

	@PostMapping("/doctor")
	public Doctor createDoctor(@Valid @RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
}
