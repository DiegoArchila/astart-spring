package com.app.astart.web.controller;

import com.app.astart.domain.Purchase;
import com.app.astart.domain.repository.PurchaseRepository;
import com.app.astart.domain.service.PurchaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseServices purchaseServices;

    @GetMapping("")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseServices.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable("id") Integer purchaseId){
        return purchaseServices.getPurchaseById(purchaseId)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/client/{client}")
    public ResponseEntity<List<Purchase>> getPurchaseByClient(@PathVariable("client") String clientId){
        return purchaseServices.getPurchasesByIdClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseServices.save(purchase), HttpStatus.CREATED);
    }
}
