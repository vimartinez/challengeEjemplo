package com.capitole.challenge.domian.spi;

import java.time.LocalDateTime;

import com.capitole.challenge.domian.api.entity.Price;
public interface PricePort {
	Price getPriceProductByDateProductBrandNativeQuery(LocalDateTime date, Integer product, Integer brand);

	boolean existsByBrandId(Integer brandId);

	boolean existsByProductId(Integer productId);
	
	Price getPriceProductByDateProductBrandNamedQuery(LocalDateTime date, Integer product, Integer brand);	
}
