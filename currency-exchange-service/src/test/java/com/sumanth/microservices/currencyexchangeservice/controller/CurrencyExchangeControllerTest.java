package com.sumanth.microservices.currencyexchangeservice.controller;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;
import com.sumanth.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CurrencyExchangeControllerTest {
    @Mock
    ExchangeValueService exchangeValueServiceMock;

    @InjectMocks
    CurrencyExchangeController currencyExchangeControllerMock;

    @Test
    void testRetrieveExchangeValue_dummyData() {
        ExchangeValueDTO exchangeValueDTODummy=new ExchangeValueDTO();
        exchangeValueDTODummy.setId(1L);
        exchangeValueDTODummy.setTo("INR");
        exchangeValueDTODummy.setFrom("USD");
        exchangeValueDTODummy.setConversionMultiple(BigDecimal.valueOf(65));
        exchangeValueDTODummy.setPort(9090);
        when(currencyExchangeControllerMock.retrieveExchangeValue(anyString(), anyString())).thenReturn(exchangeValueDTODummy);
        assertEquals(exchangeValueDTODummy,currencyExchangeControllerMock.retrieveExchangeValue(anyString(),anyString()));
    }

    @Test
    void testRetrieveExchangeValue_noData() {
        ExchangeValueDTO exchangeValueDTODummy=new ExchangeValueDTO();
        when(currencyExchangeControllerMock.retrieveExchangeValue(anyString(), anyString())).thenReturn(exchangeValueDTODummy);
        assertEquals(exchangeValueDTODummy,currencyExchangeControllerMock.retrieveExchangeValue(anyString(),anyString()));
    }
}
