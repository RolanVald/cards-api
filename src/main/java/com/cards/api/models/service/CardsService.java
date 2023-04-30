package com.cards.api.models.service;

import com.cards.api.models.dto.CardDTO;
import com.cards.api.models.entity.Card;

public interface CardsService {
    CardDTO findCardByID(Long id);
    CardDTO createACard(CardDTO cardDTO);
    CardDTO changeCardStatus(Long id, boolean status);
    CardDTO updateCard(Long id, CardDTO card);
}
