package com.example.Accounts.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.Accounts.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> valiadtionError = new HashMap<String, String>();
		List<ObjectError> valiadtionErrorList = ex.getBindingResult().getAllErrors();
		valiadtionErrorList.forEach((error) -> {
			String fielName = ((FieldError) error).getField();
			String errorMsg = error.getDefaultMessage();
			valiadtionError.put(fielName, errorMsg);
		});

		return new ResponseEntity<>(valiadtionError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex, WebRequest webRequest){
		ErrorResponseDto error = new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR,
				ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest webRequest) {
		ErrorResponseDto error = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.NOT_FOUND,
				ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExitException(CustomerAlreadyExitException ex,
			WebRequest webRequest) {

		ErrorResponseDto error = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.BAD_REQUEST,
				ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
