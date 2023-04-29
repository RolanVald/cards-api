package com.cards.api.controllers;

import com.cards.api.models.entity.Card;
import com.cards.api.models.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController{

    @Autowired
    private CardsService cardsService;

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCard(@PathVariable Long id) {
        return ResponseEntity.ok(cardsService.findCardByID(id));
    }
}
