package com.group36.healthchecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group36.healthchecker.model.MeetingRequest;

@Repository
public interface MeetingRequestRepository extends JpaRepository<MeetingRequest, Long>{

}






