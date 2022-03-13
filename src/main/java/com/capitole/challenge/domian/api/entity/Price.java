package com.capitole.challenge.domian.api.entity;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
public class Price {
	private Long id;		
	private Integer brandId;		
	private LocalDateTime startDate;		
	private LocalDateTime endDate;		
	private Integer priceList;		
	private Integer productId;		
	private Integer priority;		
	private Double price;		
	private String currency;
}