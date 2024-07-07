
package com.pharmacy.models;

public class Customer {
    private int id;
    private String name;
    private String contact;
    private String address;

    /**
     * Constructor to initialize a Customer object with ID.
     *
     * @param id      The ID of the customer.
     * @param name    The name of the customer.
     * @param contact The contact information of the customer.
     * @param address The address of the customer.
     */
    public Customer(int id, String name, String contact, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    /**
     * Constructor to initialize a Customer object without ID.
     *
     * @param name    The name of the customer.
     * @param contact The contact information of the customer.
     * @param address The address of the customer.
     */
    public Customer(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    // Getters and Setters

    /**
     * Gets the ID of the customer.
     *
     * @return The ID of the customer.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param id The ID of the customer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the contact information of the customer.
     *
     * @return The contact information of the customer.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the contact information of the customer.
     *
     * @param contact The contact information of the customer.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets the address of the customer.
     *
     * @return The address of the customer.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     *
     * @param address The address of the customer.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
