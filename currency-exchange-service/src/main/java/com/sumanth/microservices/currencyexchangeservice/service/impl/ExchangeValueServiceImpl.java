package com.sumanth.microservices.currencyexchangeservice.service.impl;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;
import com.sumanth.microservices.currencyexchangeservice.dto.mapper.ExchangeValueMapper;
import com.sumanth.microservices.currencyexchangeservice.model.ExchangeValue;
import com.sumanth.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import com.sumanth.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService {
    @Autowired
    private ExchangeValueRepository repository;

    @Autowired
    private Environment environment;

    @Override
    public ExchangeValueDTO findCurrencyExchangeByFromAndTo(String from, String to) {
        Optional<ExchangeValue> exchangeValue = Optional.ofNullable(repository.findByFromAndTo(from, to));
        if(exchangeValue.isPresent()){
            ExchangeValue exchangeValueModel=exchangeValue.get();
            ExchangeValueDTO exchangeValueDTO = ExchangeValueMapper.toExchangeValueDTO(exchangeValueModel);
            exchangeValueDTO.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return exchangeValueDTO;
        }
        return null;
    }
}
