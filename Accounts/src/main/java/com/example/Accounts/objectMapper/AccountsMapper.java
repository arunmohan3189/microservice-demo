package com.example.Accounts.objectMapper;

import com.example.Accounts.dto.AccountsDto;
import com.example.Accounts.entity.Account;

public class AccountsMapper {
	
	public static Account mapToAccount(AccountsDto accountsDto, Account account) {
		
		account.setAccountNumber(accountsDto.getAccountNumber());
		account.setAccountType(accountsDto.getAccountType());
		account.setBranchAddress(accountsDto.getBranchAddress());
		
		return account;
	}

	public static AccountsDto mapToAccountsDto(Account account, AccountsDto accountsDto) {
		accountsDto.setAccountNumber(account.getAccountNumber());
		accountsDto.setAccountType(account.getAccountType());
		accountsDto.setBranchAddress(account.getBranchAddress());
		return accountsDto;
	}
}
