package com.example.portfolio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio.Entity.Portfolio;
import com.example.portfolio.Entity.Resumecount;
import com.example.portfolio.Repository.PortfolioRepository;
import com.example.portfolio.Repository.ResumecountRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Log4j2
@RequestMapping(value = "/portfolio")
@CrossOrigin(origins = "*")

public class PortfolioController {

	@Autowired
	PortfolioRepository portfolioRepository;

	@Autowired
	ResumecountRepository resumecountRepository;

	@PostMapping("/add")
	public Portfolio addPortfolio(@RequestBody Portfolio entity) {
		Portfolio savedEntity = portfolioRepository.save(entity);
		log.info("Portfolio entity saved: {}", savedEntity);
		return savedEntity;
	}

	@PostMapping("/resumeCount")
	public Resumecount resumeCount() {
		Resumecount resumeCountEntity = resumecountRepository.findById(1).orElse(new Resumecount());

		// Increment the count
		resumeCountEntity.setCount(resumeCountEntity.getCount() + 1);

		// Save the updated count back to the database
		Resumecount updatedEntity = resumecountRepository.save(resumeCountEntity);

		log.info("Resume download count incremented: {}", updatedEntity.getCount());

		// Return the updated entity
		return updatedEntity;
	}
}
