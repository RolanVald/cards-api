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
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private String place;
    private boolean paid;
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    private BigDecimal amount;
    private BigDecimal storedMoney;
    private BigDecimal realDebt;
    @Column( updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
