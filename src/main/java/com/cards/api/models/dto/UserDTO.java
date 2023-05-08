package com.cards.api.models.dto;

import com.cards.api.models.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Long id;
    private String name;
    private String lastname;
    private String gender;
    private String email;
    private Calendar birthDay;
    private List<CardDTO> cards;
    private List<PurchaseDTO> purchases;
}
