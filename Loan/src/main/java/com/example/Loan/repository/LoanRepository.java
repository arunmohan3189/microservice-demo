package com.example.Loan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.Loan.entity.Loans;

import jakarta.transaction.Transactional;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Long>{

	Optional<Loans> findByMobileNumber(String mobileNumber);

	@Transactional
	@Modifying
	void deleteByMobileNumber(String mobileNumber);

}
