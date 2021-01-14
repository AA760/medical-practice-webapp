package com.group36.healthchecker.controller;

import com.group36.healthchecker.exception.ResourceNotFoundException;
import com.group36.healthchecker.model.Patient;
import com.group36.healthchecker.model.Patient_Record;
import com.group36.healthchecker.processor.*;
import com.group36.healthchecker.repository.PatientRepository;
import com.group36.healthchecker.repository.Patient_RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
//@RequestMapping("/")
public class Patient_RecordController {

    @Autowired
    Patient_RecordRepository patientRecordRepository;
    
    @Autowired
//    TextProcessor textProcessor;
    
    //Analyze a Job Text
//    @PostMapping("/analyze")
//    public ProcessedText analyzeProcessedText(@Valid @RequestBody ProcessedText text) {
//        AnalysisResult result = textProcessor.analyze(text.getText());
//        text.setCountFeminine(result.getCountFeminine());
//        text.setCountMasculine(result.getCountMasculine());
//        text.setGenderMap(result.getGenderMap());
//    	return text;
//    }

    // Get All Job Texts
    @GetMapping("/patientrecord")
    public List<Patient_Record> getAllPatientRecord() {
        return patientRecordRepository.findAll();
    }

    // Create a new Job Text
    @PostMapping("/patientrecord")
    public Patient_Record createPatientRecord(@Valid @RequestBody Patient_Record patient_record) {
//        ProcessedText processed = analyzeProcessedText(text);
//    	text.setId((long) 1);
    	return patientRecordRepository.save(patient_record);
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
    
    /*public void deleteNote(@PathVariable(value = "id") Long textId) {
    	textRepository.deleteById(textId)
    	.orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));
    }*/
}
