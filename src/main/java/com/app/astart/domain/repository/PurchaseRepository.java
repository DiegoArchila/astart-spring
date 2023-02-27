package com.app.astart.domain.repository;

import com.app.astart.domain.Purchase;

import java.util.List;
import java.util.Optional;
import java.lang.Integer;
import java.lang.String;


public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<Purchase> getById(Integer purchaseId);

    Optional<List<Purchase>> getByIdClient(String clientId);

    Purchase save(Purchase purchase);
}
