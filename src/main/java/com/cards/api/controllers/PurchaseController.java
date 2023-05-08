package com.cards.api.controllers;

import com.cards.api.logic.PurchaseCURDLogic;
import com.cards.api.models.dto.PurchaseDTO;
import com.cards.api.models.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseCURDLogic purchaseCURDLogic;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseCURDLogic.findPurchaseById(id));
    }

    @PostMapping
    public ResponseEntity<?> createPurchase(@RequestBody PurchaseDTO purchaseDTO) {//TODO verficar si la card y el purchase se esta creando con el usuario
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseCURDLogic.createPurchase(purchaseDTO));
    }
}
