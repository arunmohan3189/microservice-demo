package com.example.Cards.mapper;

import com.example.Cards.dto.CardsDto;
import com.example.Cards.entity.Cards;

public class CardsMapper {
	
	public static Cards mapToCards(CardsDto cardsDto,Cards cards) {
		cards.setAmountUsed(cardsDto.getAmountUsed());
		cards.setAvailableAmount(cardsDto.getAvailableAmount());
		cards.setCardNumber(cardsDto.getCardNumber());
		cards.setCardType(cardsDto.getCardType());
		cards.setMobileNumber(cardsDto.getMobileNumber());
		cards.setTotalLimit(cardsDto.getTotalLimit());
		return cards;
	}

	public static CardsDto mapToCardsDto(Cards cards,CardsDto cardsDto) {
		cardsDto.setAmountUsed(cards.getAmountUsed());
		cardsDto.setAvailableAmount(cards.getAvailableAmount());
		cardsDto.setCardNumber(cards.getCardNumber());
		cardsDto.setCardType(cards.getCardType());
		cardsDto.setMobileNumber(cards.getMobileNumber());
		cardsDto.setTotalLimit(cards.getTotalLimit());
		return cardsDto;
	}
	
}
