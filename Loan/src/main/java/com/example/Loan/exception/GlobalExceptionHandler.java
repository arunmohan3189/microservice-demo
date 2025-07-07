package com.example.Loan.exception;

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

import com.example.Loan.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest webRequest) {

		ErrorResponseDto error = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.NOT_FOUND,
				ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoanAlreadyExitException.class)
	public ResponseEntity<ErrorResponseDto> handleLoanAlreadyExitException(LoanAlreadyExitException ex,
			WebRequest webRequest) {
		ErrorResponseDto error = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.BAD_REQUEST,
				ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex, WebRequest webRequest) {
		ErrorResponseDto error = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.BAD_REQUEST,
				ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		List<ObjectError> erroList = ex.getBindingResult().getAllErrors();
		erroList.forEach((error) -> {
			String fielName = ((FieldError) error).getField();
			String fieldValue = error.getDefaultMessage();
			errorMsg.put(fielName, fieldValue);
		});
		return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
	}

}
