package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group36.healthchecker.model.MedicalHistory;
import com.group36.healthchecker.repository.MedicalHistoryRepository;

@RestController
public class MedicalHistoryController {

	@Autowired
	MedicalHistoryRepository medicalHistoryRepository;

	
	@GetMapping("/medicalhistory")
	public List<MedicalHistory> getPatient() {
		return medicalHistoryRepository.findAll();
	}

	@PostMapping("/medicalhistory")
	public MedicalHistory createPatient(@Valid @RequestBody MedicalHistory medicalHistory) {
		return medicalHistoryRepository.save(medicalHistory);
	}
}
