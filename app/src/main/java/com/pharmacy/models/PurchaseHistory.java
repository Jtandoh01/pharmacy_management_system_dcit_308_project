package com.pharmacy.models;

import java.time.LocalDateTime;

public class PurchaseHistory {
    private int id;
    private LocalDateTime purchaseDateTime;
    private String drugCode;
    private String buyer;
    private int customerId;  // Added customerId
    private int quantity;
    private double totalAmount;

    public PurchaseHistory(int id, LocalDateTime purchaseDateTime, String drugCode, String buyer, int customerId, int quantity, double totalAmount) {
        this.id = id;
        this.purchaseDateTime = purchaseDateTime;
        this.drugCode = drugCode;
        this.buyer = buyer;
        this.customerId = customerId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public String getDrugCode () {
        return drugCode;
    }

    public String getBuyer() {
        return buyer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
