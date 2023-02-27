package com.app.astart.domain.service;

import com.app.astart.domain.Purchase;
import com.app.astart.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServices {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return  (List<Purchase>) purchaseRepository.getAll();
    }

    public  Optional<Purchase> getPurchaseById(Integer purchaseId){
        //return (Optional<Purchase>) purchaseRepository.getPurchaseById(purchaseId);
        return (Optional<Purchase>) purchaseRepository.getById(purchaseId);
    }

    public Optional<List<Purchase>> getPurchasesByIdClient(String clientId){
        return  (Optional<List<Purchase>>) purchaseRepository.getByIdClient(clientId);
    }

    public Purchase save(Purchase purchase){
        purchaseRepository.save(purchase);
        return  purchase;
    }
}
