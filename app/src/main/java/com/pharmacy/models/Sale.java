package com.pharmacy.models;

import java.time.LocalDateTime;

public class Sale {
    private int id;
    private String drugCode;
    private LocalDateTime dateTime;
    private int quantity;
    private int customerId;
    private double totalAmount;

    /**
     * Constructor to initialize a Sale object without ID.
     *
     * @param drugCode    The code of the drug being sold.
     * @param customerId  The ID of the customer buying the drug.
     * @param dateTime    The date and time of the sale.
     * @param quantity    The quantity of the drug sold.
     * @param totalAmount The total amount of the sale.
     */
    public Sale(String drugCode, int customerId, LocalDateTime dateTime, int quantity, double totalAmount) {
        this.drugCode = drugCode;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    /**
     * Constructor to initialize a Sale object with ID.
     *
     * @param id          The ID of the sale.
     * @param drugCode    The code of the drug being sold.
     * @param dateTime    The date and time of the sale.
     * @param quantity    The quantity of the drug sold.
     * @param customerId  The ID of the customer buying the drug.
     * @param totalAmount The total amount of the sale.
     */
    public Sale(int id, String drugCode, LocalDateTime dateTime, int quantity, int customerId, double totalAmount) {
        this.id = id;
        this.drugCode = drugCode;
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters

    /**
     * Gets the ID of the sale.
     *
     * @return The ID of the sale.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the code of the drug being sold.
     *
     * @return The code of the drug.
     */
    public String getDrugCode() {
        return drugCode;
    }

    /**
     * Gets the date and time of the sale.
     *
     * @return The date and time of the sale.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Gets the quantity of the drug sold.
     *
     * @return The quantity of the drug sold.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the ID of the customer buying the drug.
     *
     * @return The ID of the customer.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Gets the total amount of the sale.
     *
     * @return The total amount of the sale.
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the ID of the sale.
     *
     * @param id The ID of the sale.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the code of the drug being sold.
     *
     * @param drugCode The code of the drug.
     */
    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    /**
     * Sets the date and time of the sale.
     *
     * @param dateTime The date and time of the sale.
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Sets the quantity of the drug sold.
     *
     * @param quantity The quantity of the drug.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the ID of the customer buying the drug.
     *
     * @param customerId The ID of the customer.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Sets the total amount of the sale.
     *
     * @param totalAmount The total amount of the sale.
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
