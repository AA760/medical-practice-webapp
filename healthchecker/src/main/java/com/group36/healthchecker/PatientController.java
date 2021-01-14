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
import com.group36.healthchecker.model.Patient_Record;
import com.group36.healthchecker.repository.PatientRepository;

@RestController
//@RequestMapping("/")
public class PatientController {

	@Autowired
	PatientRepository patientRepository;
	

	@Autowired
//    TextProcessor textProcessor;

	// Analyze a Job Text
//    @PostMapping("/analyze")
//    public ProcessedText analyzeProcessedText(@Valid @RequestBody ProcessedText text) {
//        AnalysisResult result = textProcessor.analyze(text.getText());
//        text.setCountFeminine(result.getCountFeminine());
//        text.setCountMasculine(result.getCountMasculine());
//        text.setGenderMap(result.getGenderMap());
//    	return text;
//    }

	// Get All Job Texts
	@GetMapping("/patient")
	public List<Patient> getPatient() {
		return patientRepository.findAll();
	}

	// Create a new Job Text
	@PostMapping("/patient")
	public Patient createPatient(@Valid @RequestBody Patient patient) {
//        ProcessedText processed = analyzeProcessedText(text);
//    	text.setId((long) 1);
		AddressController addressController = new AddressController();
		Address address=new Address();
//		patient.setRecordId(null);
//		List<Address> address=addressController.getAllAddress();
//		
//		Patient_RecordController patientRecordController = new Patient_RecordController();
//		Patient_Record patientRecord=new Patient_Record();
//		Patient_Record patientRecord1=patientRecordController.createPatientRecord(patientRecord);
//		patient.setAddressId(address.getAddressid());
//		patient.setRecordId(patientRecord1.getRecord_Id());
		return patientRepository.save(patient);
	}

	// Get a Single Job Text
//    @GetMapping("/texts/{id}")
//    public Patient getNoteById(@PathVariable(value = "id") Long textId) {
//        return textRepository.findById(textId)
//                .orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));
//    }

	// Delete a Job Text
//    @DeleteMapping("/texts/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long textId) {
//        Patient text = textRepository.findById(textId)
//                .orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));
//
//        textRepository.delete(text);
//
//        return ResponseEntity.ok().build();
//    }

	/*
	 * public void deleteNote(@PathVariable(value = "id") Long textId) {
	 * textRepository.deleteById(textId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Text", "id", textId)); }
	 */
}
