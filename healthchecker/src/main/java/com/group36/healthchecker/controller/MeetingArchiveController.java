package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group36.healthchecker.model.MeetingArchive;
import com.group36.healthchecker.repository.MeetingArchiveRepository;

@RestController
public class MeetingArchiveController {

	@Autowired
	MeetingArchiveRepository meetingArchiveRepository;
	
	@GetMapping("/meetingarchive")
	public List<MeetingArchive> getMeetingAchive() {
		return meetingArchiveRepository.findAll();
	}

	@PostMapping("/meetingarchive")
	public MeetingArchive createMeetingArchive(@Valid @RequestBody MeetingArchive meetingArchive) {
		return meetingArchiveRepository.save(meetingArchive);
	}
}
