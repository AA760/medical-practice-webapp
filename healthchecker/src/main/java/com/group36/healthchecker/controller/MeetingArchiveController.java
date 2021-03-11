package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.group36.healthchecker.exception.ResourceNotFoundException;
import com.group36.healthchecker.model.MeetingArchive;
import com.group36.healthchecker.repository.MeetingArchiveRepository;

@RestController
//@RequestMapping("/")
public class MeetingArchiveController {

	@Autowired
	MeetingArchiveRepository meetingArchiveRepository;
	

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
	@GetMapping("/meetingarchive")
	public List<MeetingArchive> getMeetingAchive() {
		return meetingArchiveRepository.findAll();
	}

	// Create a new Job Text
	@PostMapping("/meetingarchive")
	public MeetingArchive createMeetingArchive(@Valid @RequestBody MeetingArchive meetingArchive) {
		return meetingArchiveRepository.save(meetingArchive);
	}

//	 Get a Single Job Text
//    @GetMapping("/texts/{id}")
//    public MeetingArchive getNoteById(@PathVariable(value = "id") Long meetingArchiveId) {
//        return meetingArchiveRepository.findById(meetingArchiveId)
//                .orElseThrow(() -> new ResourceNotFoundException("Text", "id", meetingArchiveId));
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
