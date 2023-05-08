package com.cards.api.repository;

import com.cards.api.models.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PurchaseRepository  extends CrudRepository<Purchase, Long> {
    public Optional<Purchase> findById(Long id);
}
