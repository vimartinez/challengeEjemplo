package com.capitole.challenge;

import java.time.LocalDateTime;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.capitole.challenge.domian.api.entity.Price;
import com.capitole.challenge.infrastructure.persistence.entity.PriceEntity;

@TestConfiguration
public class ChallengeApplicationTestsConfig {

	public static final int BRAND_ID = 1;

	public static final int PRODUCT_ID = 35455;	
	
	@Bean
	public LocalDateTime expectedApplicationDate() {
		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
		return applicationDate;
	};
	
	@Bean
	public Price expectedPriceFirstRow() {
		Price data = new Price();
		data.setId(1L);
		data.setBrandId(1);
		data.setStartDate(LocalDateTime.of(2020,  06, 14, 00, 00, 00));
		data.setEndDate(LocalDateTime.of(2020,  12, 31, 23, 59, 59));
		data.setPriceList(1);
		data.setProductId(35455);
		data.setPriority(0);
		data.setPrice(35.50);
		data.setCurrency("EUR");
		return data;
	}; 
	
	@Bean
	public PriceEntity expectedPriceEntityFirstRow() {
		PriceEntity data = new PriceEntity();
		data.setId(1L);
		data.setBrandId(1);
		data.setStartDate(LocalDateTime.of(2020,  06, 14, 00, 00, 00));
		data.setEndDate(LocalDateTime.of(2020,  12, 31, 23, 59, 59));
		data.setPriceList(1);
		data.setProductId(35455);
		data.setPriority(0);
		data.setPrice(35.50);
		data.setCurrency("EUR");
		return data;
	}; 
	
	@Bean
	public PriceEntity expectedPriceEntitySecordRow() {
		PriceEntity data = new PriceEntity();
		data.setId(2L);
		data.setBrandId(1);
		data.setStartDate(LocalDateTime.of(2020,  06, 14, 15, 00, 00));
		data.setEndDate(LocalDateTime.of(2020,  06, 14, 18, 30, 00));
		data.setPriceList(2);
		data.setProductId(35455);
		data.setPriority(1);
		data.setPrice(25.45);
		data.setCurrency("EUR");
		return data;
	};
	
	@Bean
	public PriceEntity expectedPriceEntityThirdRow() {
		PriceEntity data = new PriceEntity();
		data.setId(3L);
		data.setBrandId(1);
		data.setStartDate(LocalDateTime.of(2020,  06, 15, 00, 00, 00));
		data.setEndDate(LocalDateTime.of(2020,  06, 15, 11, 00, 00));
		data.setPriceList(3);
		data.setProductId(35455);
		data.setPriority(1);
		data.setPrice(30.50);
		data.setCurrency("EUR");
		return data;
	};
	
	@Bean
	public PriceEntity expectedPriceEntityFourthRow() {
		PriceEntity data = new PriceEntity();
		data.setId(4L);
		data.setBrandId(1);
		data.setStartDate(LocalDateTime.of(2020,  06, 15, 16, 00, 00));
		data.setEndDate(LocalDateTime.of(2020,  12, 31, 23, 59, 59));
		data.setPriceList(4);
		data.setProductId(35455);
		data.setPriority(1);
		data.setPrice(38.95);
		data.setCurrency("EUR");
		return data;
	}

}
