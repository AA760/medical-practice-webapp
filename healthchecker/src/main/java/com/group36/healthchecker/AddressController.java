package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group36.healthchecker.exception.ResourceNotFoundException;
import com.group36.healthchecker.model.Address;
import com.group36.healthchecker.processor.TextProcessor;
import com.group36.healthchecker.repository.AddressRepository;


@RestController
//@RequestMapping("/")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;
    
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
    @GetMapping("/address")
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    // Create a new Job Text
    @PostMapping("/address")
    public Address createAddress(@Valid @RequestBody Address address) {
//        ProcessedText processed = analyzeProcessedText(text);
//    	text.setId((long) 1);
    	return addressRepository.save(address);
    }

    // Get a Single Job Text
//    @GetMapping("/texts/{id}")
//    public Address getNoteById(@PathVariable(value = "id") Long textId) {
//        return addressRepository.findById(textId)
//                .orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));
//    }


    // Delete a Job Text
//    @DeleteMapping("/texts/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long textId) {
//        Address text = addressRepository.findById(textId)
//                .orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));
//
//        addressRepository.delete(text);
//
//        return ResponseEntity.ok().build();
//    }
    
    /*public void deleteNote(@PathVariable(value = "id") Long textId) {
    	textRepository.deleteById(textId)
    	.orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));
    }*/
}
