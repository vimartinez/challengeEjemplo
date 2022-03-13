package com.capitole.challenge.domian.api.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper=false)
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String code;
	private HttpStatus status;
	
	public BusinessException(String code, String message, HttpStatus status) {
		super(message);
		this.code = code;
		this.status = status;
	}
}
