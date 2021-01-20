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
//@RequestMapping("/")
public class MedicalHistoryController {

	@Autowired
	MedicalHistoryRepository medicalHistoryRepository;

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
	@GetMapping("/medicalhistory")
	public List<MedicalHistory> getPatient() {
		return medicalHistoryRepository.findAll();
	}

	// Create a new Job Text
	@PostMapping("/medicalhistory")
	public MedicalHistory createPatient(@Valid @RequestBody MedicalHistory medicalHistory) {
//        ProcessedText processed = analyzeProcessedText(text);
//    	text.setId((long) 1);
		return medicalHistoryRepository.save(medicalHistory);
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
