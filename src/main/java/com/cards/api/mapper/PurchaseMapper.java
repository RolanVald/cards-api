package com.cards.api.mapper;

import com.cards.api.models.dto.PurchaseDTO;
import com.cards.api.models.entity.Purchase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PurchaseDTO toDTO(Purchase purchase) {
        return modelMapper.map(purchase, PurchaseDTO.class);
    }

    public Purchase toEntity(PurchaseDTO purchaceDTO) {
        return modelMapper.map(purchaceDTO, Purchase.class);
    }
}
