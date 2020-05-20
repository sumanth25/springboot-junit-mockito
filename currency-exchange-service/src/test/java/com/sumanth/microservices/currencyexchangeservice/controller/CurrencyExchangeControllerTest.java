package com.sumanth.microservices.currencyexchangeservice.controller;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;
import com.sumanth.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Spring boot Mockito Junit5 CurrencyExchangeControllerTest example")
public class CurrencyExchangeControllerTest {
    @Mock
    ExchangeValueService exchangeValueServiceMock;

    @InjectMocks
    CurrencyExchangeController currencyExchangeControllerMock;

    @Test
    void testRetrieveExchangeValue_dummyData() {
        //Given
        ExchangeValueDTO exchangeValueDTODummy=new ExchangeValueDTO();
        exchangeValueDTODummy.setId(1L);
        exchangeValueDTODummy.setTo("INR");
        exchangeValueDTODummy.setFrom("USD");
        exchangeValueDTODummy.setConversionMultiple(BigDecimal.valueOf(65));
        exchangeValueDTODummy.setPort(9090);

        given(exchangeValueServiceMock.findCurrencyExchangeByFromAndTo(anyString(), anyString())).willReturn(exchangeValueDTODummy);

        //When
        ExchangeValueDTO actualExchangeValueDTO = currencyExchangeControllerMock.retrieveExchangeValue(anyString(), anyString());

        //Then
        assertThat(actualExchangeValueDTO,is(exchangeValueDTODummy));

        verify(exchangeValueServiceMock).findCurrencyExchangeByFromAndTo(anyString(), anyString());
    }

    @Test
    void testRetrieveExchangeValue_noData() {
        //Given
        ExchangeValueDTO exchangeValueDTODummy=new ExchangeValueDTO();
        given(exchangeValueServiceMock.findCurrencyExchangeByFromAndTo(anyString(), anyString())).willReturn(exchangeValueDTODummy);

        //When
        ExchangeValueDTO actualExchangeValueDTO = currencyExchangeControllerMock.retrieveExchangeValue(anyString(), anyString());

        //Then
        assertThat(actualExchangeValueDTO,is(exchangeValueDTODummy));

        verify(exchangeValueServiceMock).findCurrencyExchangeByFromAndTo(anyString(), anyString());
    }

}
