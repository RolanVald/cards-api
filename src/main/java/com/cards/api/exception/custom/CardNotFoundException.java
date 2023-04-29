package com.cards.api.exception.custom;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
