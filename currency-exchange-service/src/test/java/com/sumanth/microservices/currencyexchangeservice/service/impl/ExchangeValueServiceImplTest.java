package com.sumanth.microservices.currencyexchangeservice.service.impl;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;
import com.sumanth.microservices.currencyexchangeservice.model.ExchangeValue;
import com.sumanth.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ExchangeValueServiceImplTest {
    @Mock
    private ExchangeValueRepository repositoryMock;

    @Mock
    private Environment environmentMock;

    @InjectMocks
    private ExchangeValueServiceImpl exchangeValueServiceImplMock;

    @Test
    void testFindCurrencyExchangeByFromAndTo_NotNull() {
        ExchangeValueDTO exchangeValueDTODummy=new ExchangeValueDTO();
        exchangeValueDTODummy.setId(1L);
        exchangeValueDTODummy.setFrom("USD");
        exchangeValueDTODummy.setTo("INR");
        exchangeValueDTODummy.setConversionMultiple(BigDecimal.valueOf(65));
        exchangeValueDTODummy.setPort(9090);
        ExchangeValue exchangeValueDummy=new ExchangeValue();
        exchangeValueDummy.setId(1L);
        exchangeValueDummy.setFrom("USD");
        exchangeValueDummy.setTo("INR");
        exchangeValueDummy.setConversionMultiple(BigDecimal.valueOf(65));
        String serverPort="9090";

        when(repositoryMock.findByFromAndTo(anyString(), anyString())).thenReturn(exchangeValueDummy);
        when(environmentMock.getProperty("local.server.port")).thenReturn(serverPort);
        assertEquals(exchangeValueDTODummy,exchangeValueServiceImplMock.findCurrencyExchangeByFromAndTo(anyString(),anyString()));

        verify(repositoryMock).findByFromAndTo(anyString(), anyString());
        verify(environmentMock).getProperty(("local.server.port"));
    }

    @Test
    void testFindCurrencyExchangeByFromAndTo_Null() {
        when(repositoryMock.findByFromAndTo(anyString(), anyString())).thenReturn(null);
        assertEquals(null,exchangeValueServiceImplMock.findCurrencyExchangeByFromAndTo(anyString(),anyString()));

        verify(repositoryMock).findByFromAndTo(anyString(), anyString());
    }
}