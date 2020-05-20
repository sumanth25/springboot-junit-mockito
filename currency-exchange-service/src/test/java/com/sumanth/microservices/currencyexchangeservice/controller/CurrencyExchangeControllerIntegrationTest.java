package com.sumanth.microservices.currencyexchangeservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(properties = {"local.server.port=9090"})
public class CurrencyExchangeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Integration test will test all layers from presentation, service to repository and compare actual value with expected value")
    void testRetrieveExchangeValue_integrationTest() throws Exception {
        //Given
        String expectedResult="{\"id\":1001,\"from\":\"USD\",\"to\":\"INR\",\"conversionMultiple\":65.00,\"port\":9090}";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency-exchange/from/USD/to/INR").accept(MediaType.APPLICATION_JSON);

        //When
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

        //Then
        String actualResult = result.getResponse().getContentAsString();
        assertThat(actualResult,notNullValue());
        assertThat(actualResult,equalTo(expectedResult));

    }
}
