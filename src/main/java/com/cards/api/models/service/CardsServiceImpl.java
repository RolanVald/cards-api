package com.cards.api.models.service;

import com.cards.api.exception.custom.EntityNotFoundException;
import com.cards.api.logic.UserCRUDLogic;
import com.cards.api.mapper.CardMapper;
import com.cards.api.mapper.UserMapper;
import com.cards.api.models.dto.CardDTO;
import com.cards.api.models.entity.Card;
import com.cards.api.models.entity.User;
import com.cards.api.repository.CardsRepository;
import com.cards.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardsServiceImpl implements CardsService{
    static final Logger LOG = LoggerFactory.getLogger(CardsServiceImpl.class);

    @Autowired
    private CardsRepository repository;
    @Autowired
    private UserCRUDLogic userCRUDLogic;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public CardDTO findCardByID(Long id) {
        Card card = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Card was not found"));
        return cardMapper.toDTO(card);

    }

    @Override
    public CardDTO createACard(CardDTO cardDTO) {
        LOG.info("Saving card...");
        User user = userMapper.toEntity(userCRUDLogic.findUser(cardDTO.getUserId()));
        Card  card = cardMapper.toEntity(cardDTO);
        card.setUser(user);

        repository.save(card);
        return cardMapper.toDTO(card);
    }

    @Override
    public CardDTO changeCardStatus(Long id, boolean status) {
        Card card = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Card was not found"));
        card.setActive(status);
        repository.save(card);

        LOG.info(String.format("Status of card '%s' was changed to '%s'.", card.getCardNumber(), status));
        return cardMapper.toDTO(card);
    }

    @Override
    public CardDTO updateCard(Long id, CardDTO cardDTO) {
        Card oldCard = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Card was not found"));
        Card newCard = cardMapper.toEntity(cardDTO);
        updateOldCard(newCard, oldCard);
        repository.save(oldCard);

        return cardMapper.toDTO(oldCard);
    }

    private void updateOldCard(Card newCard, Card oldCard) {
        if (!newCard.getCardNumber().isEmpty()) {
            oldCard.setCardNumber(newCard.getCardNumber());
        }
        if (!newCard.getName().isEmpty()) {
            oldCard.setName(newCard.getName());
        }
        if (newCard.getExpirationDate() != null && !newCard.getExpirationDate().isEmpty()) {
            oldCard.setExpirationDate(newCard.getExpirationDate());
        }
        if (newCard.getPaymentDeadline() != null) {
            oldCard.setPaymentDeadline(newCard.getPaymentDeadline());
        }
        if (newCard.getCutoffDate() != null) {
            oldCard.setCutoffDate(newCard.getCutoffDate());
        }
        if (newCard.getCreditAmount() != null) {
            oldCard.setCreditAmount(newCard.getCreditAmount());
        }
    }
}
