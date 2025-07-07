package com.example.Cards.iservice.serviceimpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.Cards.constants.CardConstant;
import com.example.Cards.dto.CardsDto;
import com.example.Cards.entity.Cards;
import com.example.Cards.exception.CardsAlreadyExitException;
import com.example.Cards.exception.ResourceNotFoundException;
import com.example.Cards.iservice.ICardsService;
import com.example.Cards.mapper.CardsMapper;
import com.example.Cards.repository.CardsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService{

	CardsRepository cardsRepository;
	@Override
	public void createCard(String mobileNumber) {
		Optional<Cards> cardOptional = cardsRepository.findByMobileNumber(mobileNumber);
		if(cardOptional.isPresent()) {
			throw new CardsAlreadyExitException("For given Mobile Number card already exit : "+mobileNumber);
		}
		Cards card = createNewCard(mobileNumber);
		cardsRepository.save(card);
	}

	 private Cards createNewCard(String mobileNumber) {
	        Cards newCard = new Cards();
	        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
	        newCard.setCardNumber(Long.toString(randomCardNumber));
	        newCard.setMobileNumber(mobileNumber);
	        newCard.setCardType(CardConstant.CREDIT_CARD);
	        newCard.setTotalLimit(CardConstant.NEW_CARD_LIMIT);
	        newCard.setAmountUsed(0);
	        newCard.setAvailableAmount(CardConstant.NEW_CARD_LIMIT);
	        return newCard;
	    }
	@Override
	public CardsDto getCardInfo(String mobileNumber) {
		Optional<Cards> cardOptional = cardsRepository.findByMobileNumber(mobileNumber);
		Cards card = cardOptional.orElseThrow(() ->  new ResourceNotFoundException("Card Not Found For given MobileNumber : "+mobileNumber));
		return CardsMapper.mapToCardsDto(card, new CardsDto());
	}

	@Override
	public boolean updateCardInfo(CardsDto cardsDto) {
		boolean isUpdate = false;
		Optional<Cards> cardOptional = cardsRepository.findByMobileNumber(cardsDto.getMobileNumber());
		if(cardOptional.isPresent()) {
		 cardsRepository.save(CardsMapper.mapToCards(cardsDto, cardOptional.get()));
		 isUpdate = true;
		}else {
			 new ResourceNotFoundException("Card Not Found for Given Mobile Number : "+cardsDto.getMobileNumber());
		}
		
		return isUpdate;
	}

	@Override
	public boolean deleteCardinfo(String mobileNumber) {
		
		Optional<Cards> cardOptional = cardsRepository.findByMobileNumber(mobileNumber);
		if(cardOptional.isPresent()) {
			cardsRepository.deleteByMobileNumber(mobileNumber);
			return true;
		}else {
			 new ResourceNotFoundException("Card Not Found for Given Mobile Number : "+mobileNumber);
		}
		return false;
	}

}
