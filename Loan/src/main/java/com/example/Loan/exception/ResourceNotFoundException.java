package com.example.Loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resource,String fieldName, String fieldValue) {
		super(String.format("%s not found with the given input data %s : '%s'",resource,fieldName,fieldValue));
	}
	
	

}
