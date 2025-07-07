package com.example.Accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

	@NotEmpty(message="Customer Name is Mandatory")
	@Size(min = 5, max = 10)
	private String name;

	@NotEmpty(message="Email Must be mandatory")
	private String email;

	@Pattern(regexp = "^[0-9]{10}$")
	private String mobileNumber;
	
	private AccountsDto accountsDto;

}
