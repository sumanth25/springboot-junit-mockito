package com.sumanth.microservices.currencyexchangeservice.service.impl;

import com.sumanth.microservices.currencyexchangeservice.dto.ExchangeValueDTO;
import com.sumanth.microservices.currencyexchangeservice.model.ExchangeValue;
import com.sumanth.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Spring boot Mockito Junit5 ExchangeValueServiceImplTest example")
public class ExchangeValueServiceImplTest {
    @Mock
    private ExchangeValueRepository repositoryMock;

    @Mock
    private Environment environmentMock;

    @InjectMocks
    private ExchangeValueServiceImpl exchangeValueServiceImplMock;

    @Test
    void testFindCurrencyExchangeByFromAndTo_NotNull() {
        //Given
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

        given(repositoryMock.findByFromAndTo(anyString(), anyString())).willReturn(exchangeValueDummy);
        given(environmentMock.getProperty("local.server.port")).willReturn(serverPort);

        //When
        ExchangeValueDTO actualExchangeValueDTO = exchangeValueServiceImplMock.findCurrencyExchangeByFromAndTo(anyString(), anyString());

        //Then
        assertThat(actualExchangeValueDTO,is(exchangeValueDTODummy));

        verify(repositoryMock).findByFromAndTo(anyString(), anyString());
        verify(environmentMock).getProperty(("local.server.port"));
    }

    @Test
    void testFindCurrencyExchangeByFromAndTo_Null() {
        //Given
        given(repositoryMock.findByFromAndTo(anyString(), anyString())).willReturn(null);

        //When
        ExchangeValueDTO actualExchangeValueDTO = exchangeValueServiceImplMock.findCurrencyExchangeByFromAndTo(anyString(), anyString());

        //Then
        assertThat(actualExchangeValueDTO, Matchers.nullValue());

        verify(repositoryMock).findByFromAndTo(anyString(), anyString());
    }
}
