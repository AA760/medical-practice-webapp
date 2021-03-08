package com.group36.healthchecker.controller;

import com.group36.healthchecker.model.Patient_Record;

import com.group36.healthchecker.repository.Patient_RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
public class Patient_RecordController {

    @Autowired
    Patient_RecordRepository patientRecordRepository;
    
    @GetMapping("/patientrecord")
    public List<Patient_Record> getAllPatientRecord() {
        return patientRecordRepository.findAll();
    }

    @PostMapping("/patientrecord")
    public Patient_Record createPatientRecord(@Valid @RequestBody Patient_Record patient_record) {
    	return patientRecordRepository.save(patient_record);
    }
}
