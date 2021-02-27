package com.group36.healthchecker.repository;

import com.group36.healthchecker.model.Patient2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;

public interface PatientRepository2 extends JpaRepository<Patient2, Integer> 
{
    
	
	Optional<Patient2> findById(int patient_Id);
    
    @Query(value = "SELECT patient_Id, first_name, last_name, dob, dor, address_Id, phone_No, user_Id FROM patient", nativeQuery = true)
    public List<Object[]> findPatients();
    
   
    
    
}