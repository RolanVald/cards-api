package com.cards.api.logic;

import com.cards.api.models.dto.PurchaseDTO;
import com.cards.api.models.entity.Purchase;
import com.cards.api.models.service.PurchaseService;
import com.cards.api.models.service.validations.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseCURDLogic {
    @Autowired
    private NumberService numberService;
    @Autowired
    private PurchaseService purchaseService;

    public PurchaseDTO findPurchaseById(Long id) {
        numberService.throwsExceptionIfNumberIsNotValid(id);
        return purchaseService.findPurchaseById(id);
    }

    public PurchaseDTO createPurchase(PurchaseDTO purchaseDTO) {
        return purchaseService.createPurchase(purchaseDTO);
    }
}
