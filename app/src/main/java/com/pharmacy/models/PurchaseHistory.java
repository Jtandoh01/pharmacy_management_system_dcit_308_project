// package com.pharmacy.models;

// import java.time.LocalDateTime;

// public class PurchaseHistory {
//     private int id;
//     private LocalDateTime purchaseDateTime;
//     private String drugCode;
//     private String buyer;
//     private int customerId;  // Added customerId
//     private int quantity;
//     private double totalAmount;

//     public PurchaseHistory(int id, LocalDateTime purchaseDateTime, String drugCode, String buyer, int customerId, int quantity, double totalAmount) {
//         this.id = id;
//         this.purchaseDateTime = purchaseDateTime;
//         this.drugCode = drugCode;
//         this.buyer = buyer;
//         this.customerId = customerId;
//         this.quantity = quantity;
//         this.totalAmount = totalAmount;
//     }

//     public int getId() {
//         return id;
//     }

//     public LocalDateTime getPurchaseDateTime() {
//         return purchaseDateTime;
//     }

//     public String getDrugCode () {
//         return drugCode;
//     }

//     public String getBuyer() {
//         return buyer;
//     }

//     public int getCustomerId() {
//         return customerId;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     public double getTotalAmount() {
//         return totalAmount;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
//         this.purchaseDateTime = purchaseDateTime;
//     }

//     public void setDrugCode(String drugCode) {
//         this.drugCode = drugCode;
//     }

//     public void setBuyer(String buyer) {
//         this.buyer = buyer;
//     }

//     public void setCustomerId(int customerId) {
//         this.customerId = customerId;
//     }

//     public void setQuantity(int quantity) {
//         this.quantity = quantity;
//     }

//     public void setTotalAmount(double totalAmount) {
//         this.totalAmount = totalAmount;
//     }
// }
package com.pharmacy.models;

import java.time.LocalDateTime;

public class PurchaseHistory {
    private int id;
    private LocalDateTime purchaseDateTime;
    private String drugCode;
    private String buyer;
    private int customerId;
    private int quantity;
    private double totalAmount;

    /**
     * Constructor to initialize a PurchaseHistory object with all fields.
     *
     * @param id               The ID of the purchase history record.
     * @param purchaseDateTime The date and time of the purchase.
     * @param drugCode         The code of the drug purchased.
     * @param buyer            The name of the buyer.
     * @param customerId       The ID of the customer.
     * @param quantity         The quantity of the drug purchased.
     * @param totalAmount      The total amount of the purchase.
     */
    public PurchaseHistory(int id, LocalDateTime purchaseDateTime, String drugCode, String buyer, int customerId, int quantity, double totalAmount) {
        this.id = id;
        this.purchaseDateTime = purchaseDateTime;
        this.drugCode = drugCode;
        this.buyer = buyer;
        this.customerId = customerId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters

    /**
     * Gets the ID of the purchase history record.
     *
     * @return The ID of the purchase history record.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the date and time of the purchase.
     *
     * @return The date and time of the purchase.
     */
    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    /**
     * Gets the code of the drug purchased.
     *
     * @return The code of the drug purchased.
     */
    public String getDrugCode() {
        return drugCode;
    }

    /**
     * Gets the name of the buyer.
     *
     * @return The name of the buyer.
     */
    public String getBuyer() {
        return buyer;
    }

    /**
     * Gets the ID of the customer.
     *
     * @return The ID of the customer.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Gets the quantity of the drug purchased.
     *
     * @return The quantity of the drug purchased.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the total amount of the purchase.
     *
     * @return The total amount of the purchase.
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the ID of the purchase history record.
     *
     * @param id The ID of the purchase history record.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the date and time of the purchase.
     *
     * @param purchaseDateTime The date and time of the purchase.
     */
    public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    /**
     * Sets the code of the drug purchased.
     *
     * @param drugCode The code of the drug purchased.
     */
    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    /**
     * Sets the name of the buyer.
     *
     * @param buyer The name of the buyer.
     */
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param customerId The ID of the customer.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Sets the quantity of the drug purchased.
     *
     * @param quantity The quantity of the drug purchased.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the total amount of the purchase.
     *
     * @param totalAmount The total amount of the purchase.
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
