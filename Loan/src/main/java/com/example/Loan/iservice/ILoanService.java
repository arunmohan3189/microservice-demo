package com.example.Loan.iservice;

import com.example.Loan.dto.LoansDto;

public interface ILoanService {

	void createLoan(String mobileNumber);

	LoansDto fetchLoan(String mobileNumber);

	boolean updateLoanDetails(LoansDto loansDto);

	boolean deleteLoan(String mobileNumber);
}
