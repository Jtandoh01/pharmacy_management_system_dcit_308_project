package com.pharmacy.models;

import java.util.List;

public class Drug {
    private String drugCode;
    private String name;
    private String description;
    private int quantity;
    private List<Supplier> suppliers;
    private List<PurchaseHistory> purchaseHistory;

    public Drug(String drugCode, String name, String description, int quantity) {
        this.drugCode = drugCode;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<PurchaseHistory> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
}
