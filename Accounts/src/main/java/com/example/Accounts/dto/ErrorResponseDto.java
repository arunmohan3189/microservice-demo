package com.example.Accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ErrorResponseDto {
	
	private String apiPath;
	private HttpStatus statusCode;
	private String errorMsg;
	private LocalDateTime errorTime;

}
