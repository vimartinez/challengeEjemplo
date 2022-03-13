package com.capitole.challenge.application.rest.dto;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
public class PriceDto {
	private Integer productId;
	private Integer brandId;		
	private Integer priceList;		
	private LocalDateTime startDate;		
	private LocalDateTime endDate;	
	private Double price;
}
