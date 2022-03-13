package com.capitole.challenge.domian.api.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RequestException extends RuntimeException{
	
	private static final long serialVersionUID = 111111L;
	private String code;
	
	public RequestException(String code, String message) {
		super(message);
		this.code = code;
	}

}

