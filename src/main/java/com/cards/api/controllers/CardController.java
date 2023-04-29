package com.cards.api.controllers;

import com.cards.api.exception.custom.CardNotFoundException;
import com.cards.api.logic.CardCRUDLogic;
import com.cards.api.models.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController{

    @Autowired
    private CardCRUDLogic cardLogic;

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCard(@PathVariable Long id) throws CardNotFoundException {
        return ResponseEntity.ok(cardLogic.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody Card card) {
        //ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedObjectId).toUri()).build()
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand(cardLogic.createCard(card))
                .toUri()).build();
    }
}
