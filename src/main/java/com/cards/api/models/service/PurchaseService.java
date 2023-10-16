package com.cards.api.models.service;

import com.cards.api.models.dto.PurchaseDTO;
import com.cards.api.models.entity.Purchase;

public interface PurchaseService {

    PurchaseDTO findPurchaseById(Long id);
    PurchaseDTO createPurchase(PurchaseDTO purchaseDTO);
    PurchaseDTO updatePurchase(PurchaseDTO purchaseDTO, Long id);
}
