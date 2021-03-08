package com.group36.healthchecker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group36.healthchecker.model.Videos_and_Articles;
import com.group36.healthchecker.repository.Videos_and_ArticlesRepository;

@RestController
public class Videos_and_ArticlesController {

	@Autowired
	Videos_and_ArticlesRepository videoAndArticlesRepository;
	

	@GetMapping("/videosandarticles")
	public List<Videos_and_Articles> getPatient() {
		return videoAndArticlesRepository.findAll();
	}

	@PostMapping("/videosandarticles")
	public Videos_and_Articles createPatient(@Valid @RequestBody Videos_and_Articles videosAndArticles) {
		return videoAndArticlesRepository.save(videosAndArticles);
	}
}
