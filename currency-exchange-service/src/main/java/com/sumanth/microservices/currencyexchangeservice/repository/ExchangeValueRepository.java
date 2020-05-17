package com.sumanth.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumanth.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from, String to);
}
