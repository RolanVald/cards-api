package com.cards.api.logic;

import com.cards.api.models.entity.Card;
import com.cards.api.models.service.CardsService;
import com.cards.api.models.service.validations.NumberService;
import com.cards.api.models.service.validations.ValidateCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardCRUDLogic {

    @Autowired
    private CardsService cardsService;
    @Autowired
    private NumberService numberService;
    @Autowired
    private ValidateCardService validateCardService;

    public Card getCardById(Long id){
        numberService.throwsExceptionIfNumberIsNotValid(id);
        return cardsService.findCardByID(id);
    }

    public Card createCard(Card card) {
        validateCardService.throwsExceptionIfCreditCardIsNotValid(card.getCardNumber());
        return cardsService.createACard(card);
    }
}
