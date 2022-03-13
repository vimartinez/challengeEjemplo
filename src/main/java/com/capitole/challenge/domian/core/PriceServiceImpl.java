package com.capitole.challenge.domian.core;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.capitole.challenge.domian.api.entity.Price;
import com.capitole.challenge.domian.api.exception.BusinessException;
import com.capitole.challenge.domian.api.exception.RequestException;
import com.capitole.challenge.domian.api.service.PriceService;
import com.capitole.challenge.domian.spi.PricePort;

@Service
public class PriceServiceImpl implements PriceService {

	private final PricePort port;
	
	public PriceServiceImpl(PricePort port) {
		this.port = port;
	}
	
	@Override
	public Price getPriceProductByDateProductBrand(LocalDateTime date, Integer product, Integer brand) {
		
		validateParams(brand, product);
		
		Price data = this.port.getPriceProductByDateProductBrandNativeQuery(date, product, brand);
		if(data==null) {
			throw new BusinessException("E-300","No data found!!!", HttpStatus.NO_CONTENT);
		}
		
		return data;
	}

	@Override
	public Price getPriceProductByDateProductBrandNamedQuery(LocalDateTime date, Integer product, Integer brand) {
		validateParams(brand, product);		

		Price data = this.port.getPriceProductByDateProductBrandNamedQuery(date, product, brand);
		if(data==null) {
			throw new BusinessException("E-300","No data found!!!", HttpStatus.NO_CONTENT);
		}
		
		return data;
	}
	
	
	
	private void validateParams(Integer brandId, Integer productId) {
		boolean brandExists = port.existsByBrandId(brandId);
		if(!brandExists) {
			throw new RequestException("E-400","The brand was not found!!!");
		}
		
		boolean productExists = port.existsByProductId(productId);		
		if(!productExists) {
			throw new RequestException("E-401","The product was not found!!!");
		}
	}

}
