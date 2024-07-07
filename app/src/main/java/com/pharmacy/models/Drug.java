

package com.pharmacy.models;

import java.util.ArrayList;
import java.util.List;

public class Drug {
    private String drugCode;
    private String name;
    private String description;
    private int quantity;
    private Float price;
    private List<Supplier> suppliers;
    private List<PurchaseHistory> purchaseHistory;

    /**
     * Constructor to initialize a Drug object.
     *
     * @param drugCode    The code of the drug.
     * @param name        The name of the drug.
     * @param description The description of the drug.
     * @param quantity    The quantity of the drug.
     * @param price       The price of the drug.
     */
    public Drug(String drugCode, String name, String description, int quantity, Float price) {
        this.drugCode = drugCode;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.suppliers = new ArrayList<>();
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

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return price;
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
