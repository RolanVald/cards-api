package com.cards.api.exception.custom;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
