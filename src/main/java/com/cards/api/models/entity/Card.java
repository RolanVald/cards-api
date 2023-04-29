package com.cards.api.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Card {

    @Id
    private Long id;
    private String name;
    private String cardNumber;
    private String expirationDate;
    private Date paymentDeadline;
    private Date cutoffDate;
    private BigDecimal creditAmount;
    private String createBy;
    @Column( updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    protected void prePersist() {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = new Date();
    }
}
