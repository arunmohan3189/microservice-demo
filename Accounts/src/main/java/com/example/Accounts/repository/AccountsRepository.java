package com.example.Accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.Accounts.entity.Account;

import jakarta.transaction.Transactional;


@Repository
public interface AccountsRepository extends JpaRepository<Account, Long>{

	Account findByCustomerId(Long customerId);

	Optional<Account> findByAccountNumber(Long accountNumber);

	@Transactional
	@Modifying
	void deleteByCustomerId(Long customerId);
}
