package com.example.Loan.ObjectMapper;

import com.example.Loan.dto.LoansDto;
import com.example.Loan.entity.Loans;

public class LoansMapper {
	
	public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setTotalLoan(loansDto.getTotalLoan());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
		return loans;
	}

	public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
		loansDto.setLoanNumber(loans.getLoanNumber());
		loansDto.setLoanType(loans.getLoanType());
		loansDto.setMobileNumber(loans.getMobileNumber());
		loansDto.setAmountPaid(loans.getAmountPaid());
		loansDto.setOutstandingAmount(loans.getOutstandingAmount());
		loansDto.setTotalLoan(loans.getTotalLoan());
		return loansDto;
	}
	
}
