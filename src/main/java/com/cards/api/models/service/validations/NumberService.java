package com.cards.api.models.service.validations;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    public boolean isValidNumber(Long number) { return number>=0;}

    public boolean throwsExceptionIfNumberIsNotValid(Long number) {
        String message = "Number '%s' is not a valid number.";
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(String.format(message, number));
        }
        return true;
    }
}
