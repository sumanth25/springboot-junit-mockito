package com.sumanth.microservices.currencyexchangeservice.controller;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;
import com.sumanth.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExchangeValueService service;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValueDTO retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValueDTO exchangeValue = service.findCurrencyExchangeByFromAndTo(from, to);
		logger.info("{}",exchangeValue);
		return exchangeValue;
	}
}
