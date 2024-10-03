package com.example.portfolio.Entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="resumeCount")
public class Resumecount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int count = 0; 
	private String ipaddress;
}
