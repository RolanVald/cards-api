package com.cards.api.controllers;

import com.cards.api.logic.PurchaseCURDLogic;
import com.cards.api.models.dto.PurchaseDTO;
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
    public ResponseEntity<?> createPurchase(@RequestBody PurchaseDTO purchaseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseCURDLogic.createPurchase(purchaseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchase(@PathVariable Long id, @RequestBody  PurchaseDTO purchaseDTO) {
        return ResponseEntity.ok(purchaseCURDLogic.updatePurchase(purchaseDTO,  id));
    }
}
