package com.cards.api.mapper;

import com.cards.api.models.dto.CardDTO;
import com.cards.api.models.entity.Card;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CardDTO toDTO(Card card) {
        return  modelMapper.map(card, CardDTO.class);
    }

    public Card toEntity(CardDTO cardDTO) {
        return modelMapper.map(cardDTO, Card.class);
    }
}
