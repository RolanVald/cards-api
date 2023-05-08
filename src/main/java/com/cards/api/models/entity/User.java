package com.cards.api.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String gender;
    private String email;
    private String password;
    @Temporal(TemporalType.DATE)
    private Calendar birthDay;
    @CreatedBy
    private String createBy;
    @Column( updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Card> cards;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Purchase> purchases;

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
