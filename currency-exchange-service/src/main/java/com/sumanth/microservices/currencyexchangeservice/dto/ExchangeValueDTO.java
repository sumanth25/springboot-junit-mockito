package com.sumanth.microservices.currencyexchangeservice.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ExchangeValueDTO {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
}
