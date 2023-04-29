package com.cards.api.models.service.validations;

import org.springframework.stereotype.Component;

@Component
public class ValidateCardService {

    public boolean isValidCard(String ccNumber) {
        final boolean[] dbl = {false};
        return ccNumber
                .replaceAll("\\s+", "")
                .chars()
                .map(c -> Character.digit((char) c, 10))
                .map(i -> ((dbl[0] = !dbl[0])) ? (((i*2)>9) ? (i*2)-9 : i*2) : i)
                .sum() % 10 == 0;
    }

    public  boolean throwsExceptionIfCreditCardIsNotValid(String ccNumber) {
        String message = "Credit card number ('%s') is not valid.";
        if (!isValidCard(ccNumber)) {
            throw new IllegalArgumentException(String.format(message, ccNumber));
        }
        return true;
    }
}
