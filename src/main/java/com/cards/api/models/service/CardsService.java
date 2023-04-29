package com.cards.api.models.service;

import com.cards.api.models.entity.Card;

public interface CardsService {
    Card findCardByID(Long id);
}
