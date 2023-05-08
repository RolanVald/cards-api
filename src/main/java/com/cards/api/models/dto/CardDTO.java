package com.cards.api.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CardDTO {

    private Long id;
    private String name;
    private String cardNumber;
    private String expirationDate;
    private Date paymentDeadline;
    private Date cutoffDate;
    private BigDecimal creditAmount;
    private BigDecimal available;
    private Boolean active;
    private Long userId;
}
