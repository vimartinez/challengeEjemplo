package com.capitole.challenge.infrastructure.persistence.entity;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.NoArgsConstructor
@lombok.Data

@Entity(name="Prices")
@Table(name="PRICES")
public class PriceEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="BRAND_ID", nullable = false)
	private Integer brandId;
	
	@Column(name="START_DATE", nullable = false)
	private LocalDateTime startDate;
	
	@Column(name="END_DATE", nullable = false)
	private LocalDateTime endDate;
	
	@Column(name="PRICE_LIST", nullable = false)
	private Integer priceList;
	
	@Column(name="PRODUCT_ID", nullable = false)
	private Integer productId;
	
	@Column(name="PRIORITY", nullable = false)
	private Integer priority;
	
	@Column(name="PRICE", nullable = false)
	private Double price;
	
	@Column(name="CURRENCY", nullable = false)
	private String currency;
	
}
