package com.example.Accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resourceName, String fielName, String fieldValue) {
		super(String.format("%s not found Exception with the Given Input Data %s : '%s'",resourceName,fielName,fieldValue));
	}
	
	

}
