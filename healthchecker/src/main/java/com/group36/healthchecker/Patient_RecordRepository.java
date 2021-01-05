package com.example.groupproject.repository;

import com.example.groupproject.model.Patient_Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patient_RecordRepository extends JpaRepository<Patient_Record, Long>{

}






