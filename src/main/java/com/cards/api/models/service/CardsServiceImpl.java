package com.cards.api.models.service;

import com.cards.api.models.entity.Card;
import com.cards.api.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardsServiceImpl implements CardsService{
    static final Logger LOG = LoggerFactory.getLogger(CardsServiceImpl.class);
    @Autowired
    private CardsRepository repository;

    @Override
    public Card findCardByID(Long id) {
        try {
            return repository.findById(id)
                    .orElseThrow(Exception::new);
        } catch (Exception e) {
            LOG.error("Error trying to get card {}", e.getMessage());

        }
        return new Card();
    }
}
