package com.capitole.challenge.application.rest.resource;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.challenge.application.rest.dto.PriceDto;
import com.capitole.challenge.application.rest.mapper.PriceDtoMapper;
import com.capitole.challenge.domian.api.service.PriceService;

@RestController
@RequestMapping("/api")
public class PriceResource {	
	
	/** The service. */
	private final PriceService service;
	private final PriceDtoMapper mapper;
	
	public PriceResource (PriceService service, PriceDtoMapper mapper) {
		this.service = service;
		this.mapper=mapper;
	}
	
	@GetMapping("/findPrice")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<PriceDto> findByApplicationDateProductBrand(
			@RequestParam(value="applicationDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
			@RequestParam(value="product", required = true) Integer product,
			@RequestParam(value="brand", required = true) Integer brand
			) {
		return ResponseEntity.ok(this.mapper.map(this.service.getPriceProductByDateProductBrand(applicationDate, product, brand)));		
	}
}

