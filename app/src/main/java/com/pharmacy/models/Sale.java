// package com.pharmacy.models;

// import java.time.LocalDateTime;

// public class Sale {
//     private int id;
//     private Drug drug;
//     private int quantity;
//     private double totalAmount;
//     private LocalDateTime saleDate;
//     private Customer customer;

//     public Sale(int id, Drug drug, int quantity, double totalAmount, LocalDateTime saleDate, Customer customer) {
//         this.id = id;
//         this.drug = drug;
//         this.quantity = quantity;
//         this.totalAmount = totalAmount;
//         this.saleDate = saleDate;
//         this.customer = customer;
//     }

//     // Getters and Setters
//     public int getId() { return id; }
//     public void setId(int id) { this.id = id; }

//     public Drug getDrug() { return drug; }
//     public void setDrug(Drug drug) { this.drug = drug; }

//     public int getQuantity() { return quantity; }
//     public void setQuantity(int quantity) { this.quantity = quantity; }

//     public double getTotalAmount() { return totalAmount; }
//     public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

//     public LocalDateTime getSaleDate() { return saleDate; }
//     public void setSaleDate(LocalDateTime saleDate) { this.saleDate = saleDate; }

//     public Customer getCustomer() { return customer; }
//     public void setCustomer(Customer customer) { this.customer = customer; }
// }
package com.pharmacy.models;

import java.time.LocalDateTime;

public class Sale {
    private int id;
    private Drug drug;
    private int quantity;
    private double totalAmount;
    private LocalDateTime saleDate;
    private Customer customer;

    public Sale(int id, Drug drug, int quantity, double totalAmount, LocalDateTime saleDate, Customer customer) {
        this.id = id;
        this.drug = drug;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.saleDate = saleDate;
        this.customer = customer;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Drug getDrug() { return drug; }
    public void setDrug(Drug drug) { this.drug = drug; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public LocalDateTime getSaleDate() { return saleDate; }
    public void setSaleDate(LocalDateTime saleDate) { this.saleDate = saleDate; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
