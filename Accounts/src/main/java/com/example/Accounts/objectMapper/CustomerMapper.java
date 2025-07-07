package com.example.Accounts.objectMapper;

import com.example.Accounts.dto.CustomerDto;
import com.example.Accounts.entity.Customer;

public class CustomerMapper {

	public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setName(customerDto.getName());
		return customer;
	}
	
	public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		customerDto.setName(customer.getName());
		return customerDto;
	}
}
