package com.group36.healthchecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group36.healthchecker.model.Patient_Record;

@Repository
public interface Patient_RecordRepository extends JpaRepository<Patient_Record, Long>{

}






