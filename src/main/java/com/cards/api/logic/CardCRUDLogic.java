package com.cards.api.logic;

import com.cards.api.models.dto.CardDTO;
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

    public CardDTO getCardById(Long id){
        numberService.throwsExceptionIfNumberIsNotValid(id);
        return cardsService.findCardByID(id);
    }

    public CardDTO createCard(CardDTO card) {
        validateCardService.throwsExceptionIfCreditCardIsNotValid(card.getCardNumber());
        return cardsService.createACard(card);
    }

    public CardDTO changeCardStatus(Long id, boolean status) {
        numberService.throwsExceptionIfNumberIsNotValid(id);
        return cardsService.changeCardStatus(id, status);
    }

    public CardDTO updateCard(Long id, CardDTO cardDTO) {
        return cardsService.updateCard(id, cardDTO);
    }
}
