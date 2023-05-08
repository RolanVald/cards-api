package com.cards.api.models.service;

import com.cards.api.exception.custom.EntityNotFoundException;
import com.cards.api.mapper.PurchaseMapper;
import com.cards.api.models.dto.PurchaseDTO;
import com.cards.api.models.entity.Purchase;
import com.cards.api.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    static final Logger LOG = LoggerFactory.getLogger(CardsServiceImpl.class);

    @Autowired
    private PurchaseMapper purchaseMapper;
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
        Purchase purchase = purchaseMapper.toEntity(purchaseDTO);
        return purchaseMapper.toDTO(purchaseRepository.save(purchase));
    }
}
