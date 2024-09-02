package com.example.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.Entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long>   {

}
