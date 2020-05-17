package com.sumanth.microservices.currencyexchangeservice.dto.mapper;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;
import com.sumanth.microservices.currencyexchangeservice.model.ExchangeValue;

public class ExchangeValueMapper {
    public static ExchangeValueDTO toExchangeValueDTO(ExchangeValue exchangeValue){
        ExchangeValueDTO exchangeValueDTO=new ExchangeValueDTO();
        exchangeValueDTO.setId(exchangeValue.getId());
        exchangeValueDTO.setFrom(exchangeValue.getFrom());
        exchangeValueDTO.setTo(exchangeValue.getTo());
        exchangeValueDTO.setConversionMultiple(exchangeValue.getConversionMultiple());
        return exchangeValueDTO;
    }
}
