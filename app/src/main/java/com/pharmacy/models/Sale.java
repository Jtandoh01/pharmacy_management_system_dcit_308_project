package com.pharmacy.models;

import java.time.LocalDateTime;

public class Sale {
    private int id;
    private String drugCode;
    private LocalDateTime dateTime;
    private int quantity;
    private int customerId;
    private double totalAmount;

    public Sale(String drugCode, int customerId, LocalDateTime dateTime, int quantity, double totalAmount) {
        this.drugCode = drugCode;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public Sale(int id, String drugCode, LocalDateTime dateTime, int quantity, int customerId, double totalAmount) {
        this.id = id;
        this.drugCode = drugCode;
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public String getDrugCode () {
        return drugCode;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
