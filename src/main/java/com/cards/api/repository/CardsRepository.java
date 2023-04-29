package com.cards.api.repository;

import com.cards.api.models.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardsRepository extends CrudRepository<Card, Long> {
    public Optional<Card> findById(Long id);
}
