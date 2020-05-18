package com.sumanth.microservices.currencyexchangeservice.model;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ExchangeValue {
	
	@Id
	private Long id;
	
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	
}
