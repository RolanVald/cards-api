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
public class PurchaseDTO {

    private Long id;
    private String item;
    private String place;
    private boolean paid;
    private Date purchaceDate;
    private BigDecimal amount;
    private BigDecimal storedMoney;
    private BigDecimal realDebt;
}
