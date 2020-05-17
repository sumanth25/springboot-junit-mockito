package com.sumanth.microservices.currencyexchangeservice.service;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;

public interface ExchangeValueService {
    ExchangeValueDTO findCurrencyExchangeByFromAndTo(String from, String to);
}
