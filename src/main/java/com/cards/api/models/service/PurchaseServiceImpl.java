package com.cards.api.models.service;

import com.cards.api.exception.custom.EntityNotFoundException;
import com.cards.api.logic.CardCRUDLogic;
import com.cards.api.logic.UserCRUDLogic;
import com.cards.api.mapper.CardMapper;
import com.cards.api.mapper.PurchaseMapper;
import com.cards.api.mapper.UserMapper;
import com.cards.api.models.dto.PurchaseDTO;
import com.cards.api.models.entity.Card;
import com.cards.api.models.entity.Purchase;
import com.cards.api.models.entity.User;
import com.cards.api.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    static final Logger LOG = LoggerFactory.getLogger(CardsServiceImpl.class);

    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardCRUDLogic cardCRUDLogic;
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public PurchaseDTO findPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Purchase not found"));
        return purchaseMapper.toDTO(purchase);
    }

    @Override
    public PurchaseDTO createPurchase(PurchaseDTO purchaseDTO) {
        LOG.info("Saving purchase...");
        Purchase purchase = purchaseMapper.toEntity(purchaseDTO);
        Card card = cardMapper.toEntity(cardCRUDLogic.getCardById(purchaseDTO.getCardId()));
        purchase.setCard(card);

        return purchaseMapper.toDTO(purchaseRepository.save(purchase));
    }

    @Override
    public PurchaseDTO updatePurchase(PurchaseDTO purchaseDTO, Long id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Purchase not found"));
        Purchase newPurchase = purchaseMapper.toEntity(purchaseDTO);
        updateOldPurchase(purchase,newPurchase);

        return purchaseMapper.toDTO(purchaseRepository.save(purchase));
    }

    private void updateOldPurchase(Purchase old, Purchase newPurchase) {
        if (!newPurchase.getItem().isEmpty()) {
            old.setItem(newPurchase.getItem());
        }
        if (!newPurchase.getPlace().isEmpty()) {
            old.setPlace(newPurchase.getPlace());
        }
        if (newPurchase.getPurchaseDate() != null) {
            old.setPurchaseDate(newPurchase.getPurchaseDate());
        }
        if (newPurchase.getAmount().compareTo(BigDecimal.ZERO) >= 0 ) {
            old.setAmount(newPurchase.getAmount());
        }
        if (newPurchase.getStoredMoney().compareTo(BigDecimal.ZERO) >= 0)  {
            old.setStoredMoney(newPurchase.getStoredMoney());
        }
    }
}
