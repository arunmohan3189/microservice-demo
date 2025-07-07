package com.example.Cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.Cards.entity.Cards;

import jakarta.transaction.Transactional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long>{

	Optional<Cards> findByMobileNumber(String mobileNumber);

	@Transactional
	@Modifying
	void deleteByMobileNumber(String mobileNumber);

}
