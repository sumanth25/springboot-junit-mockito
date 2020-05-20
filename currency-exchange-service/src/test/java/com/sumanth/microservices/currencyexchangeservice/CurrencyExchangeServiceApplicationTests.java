package com.sumanth.microservices.currencyexchangeservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Spring boot Mockito Junit5 CurrencyExchangeServiceApplicationTests example")
class CurrencyExchangeServiceApplicationTests {

	@Test
	void testMain() {
		CurrencyExchangeServiceApplication.main(new String[] {});
	}

}
