package com.app.astart.domain;

import com.app.astart.persistence.entity.Cliente;

import java.time.LocalDateTime;
import java.lang.Integer;
import java.lang.Character;
import java.lang.String;
import java.util.List;


public class Purchase {

    private Integer purchaseId;
    private Integer clientId;
    private LocalDateTime date;
    private Character payMethod;
    private String comment;
    private Character state;

    private List<PurchaseItem> items;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Character getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Character payMethod) {
        this.payMethod = payMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> item) {
        this.items = item;
    }
}
