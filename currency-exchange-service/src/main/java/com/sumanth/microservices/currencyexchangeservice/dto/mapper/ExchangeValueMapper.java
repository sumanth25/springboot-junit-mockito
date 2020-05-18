package com.sumanth.microservices.currencyexchangeservice.dto.mapper;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;

public class ExchangeValueMapper {
    public static ExchangeValueDTO toExchangeValueDTO(com.sumanth.microservices.currencyexchangeservice.model.ExchangeValue exchangeValue){
        ExchangeValueDTO exchangeValueDTODummy =new ExchangeValueDTO();
        exchangeValueDTODummy.setId(exchangeValue.getId());
        exchangeValueDTODummy.setFrom(exchangeValue.getFrom());
        exchangeValueDTODummy.setTo(exchangeValue.getTo());
        exchangeValueDTODummy.setConversionMultiple(exchangeValue.getConversionMultiple());
        return exchangeValueDTODummy;
    }
}
