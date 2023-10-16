package com.cards.api.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cardNumber;
    private String expirationDate;
    private Date paymentDeadline;
    private Date cutoffDate;
    private BigDecimal creditAmount;
    private BigDecimal available;
    private boolean active;
    private String createBy;
    @Column( updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Purchase> purchases;

    @PrePersist
    protected void prePersist() {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
        this.createBy = "User";
        this.active = true;
        this.available = this.creditAmount;
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = new Date();
    }
}
