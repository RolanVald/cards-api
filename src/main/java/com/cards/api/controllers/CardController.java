package com.cards.api.controllers;

import com.cards.api.exception.custom.EntityNotFoundException;
import com.cards.api.logic.CardCRUDLogic;
import com.cards.api.models.dto.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/card")
public class CardController{

    @Autowired
    private CardCRUDLogic cardLogic;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCard(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(cardLogic.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody CardDTO card) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardLogic.createCard(card));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCard(@PathVariable Long id, @RequestBody CardDTO card) {
        return ResponseEntity.ok(cardLogic.updateCard(id, card));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> changeCardStatus(@PathVariable Long id, @RequestBody boolean status) {
        return ResponseEntity.ok(cardLogic.changeCardStatus(id, status));
    }
}
