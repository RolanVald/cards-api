package com.cards.api.models.service;

import com.cards.api.exception.custom.CardNotFoundException;
import com.cards.api.models.entity.Card;
import com.cards.api.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardsServiceImpl implements CardsService{
    static final Logger LOG = LoggerFactory.getLogger(CardsServiceImpl.class);
    @Autowired
    private CardsRepository repository;

    @Override
    public Card findCardByID(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new CardNotFoundException("Card was not found"));
    }

    @Override
    public Card createACard(Card card) {
        return repository.save(card);
    }
}
