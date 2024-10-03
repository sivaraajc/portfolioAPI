package com.example.portfolio.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio.Entity.Portfolio;
import com.example.portfolio.Entity.Resumecount;
import com.example.portfolio.Repository.PortfolioRepository;
import com.example.portfolio.Repository.ResumecountRepository;

import jakarta.servlet.http.HttpServletRequest;

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
	public Resumecount resumeCount(HttpServletRequest request) {
	    // Create a new Resumecount entity
	    Resumecount resumeCountEntity = new Resumecount();
	    resumeCountEntity.setCount(1);  // Since it's a new entry, starting with 1
	    String clientIpAddress = request.getRemoteAddr();
	    resumeCountEntity.setIpaddress(clientIpAddress);
	    Resumecount savedEntity = resumecountRepository.save(resumeCountEntity);

	    log.info("New resume download entry created with ID: {}, Count: {}, and IP Address: {}", 
	             savedEntity.getId(), savedEntity.getCount(), savedEntity.getIpaddress());

	    // Return the newly created entity
	    return savedEntity;
	}

}
