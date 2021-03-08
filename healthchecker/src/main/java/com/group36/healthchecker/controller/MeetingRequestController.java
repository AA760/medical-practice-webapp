package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group36.healthchecker.model.MeetingRequest;
import com.group36.healthchecker.repository.MeetingRequestRepository;

@RestController
public class MeetingRequestController {

	@Autowired
	MeetingRequestRepository meetingRequestRepository;

	@GetMapping("/meetingrequest")
	public List<MeetingRequest> getMeetingRequest() {
		return meetingRequestRepository.findAll();
	}

	@PostMapping("/meetingrequest")
	public MeetingRequest createMeetingRequest(@Valid @RequestBody MeetingRequest meetingRequest) {

		return meetingRequestRepository.save(meetingRequest);
	}
}
