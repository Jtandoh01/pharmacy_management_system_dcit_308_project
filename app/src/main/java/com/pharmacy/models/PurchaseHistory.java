package com.pharmacy.models;

import java.time.LocalDateTime;

public class PurchaseHistory {
    private int id;
    private LocalDateTime purchaseDateTime;
    private String drugCode;
    private String buyer;
    private int quantity;
    private double totalAmount;

    public PurchaseHistory(int id, LocalDateTime purchaseDateTime, String drugCode, String buyer, int quantity, double totalAmount) {
        this.id = id;
        this.purchaseDateTime = purchaseDateTime;
        this.drugCode = drugCode;
        this.buyer = buyer;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
