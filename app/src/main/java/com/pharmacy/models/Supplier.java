
package com.pharmacy.models;

public class Supplier {
    private int id;
    private String name;
    private String location;

    /**
     * Constructor to initialize a Supplier object with ID.
     *
     * @param id       The ID of the supplier.
     * @param name     The name of the supplier.
     * @param location The location of the supplier.
     */
    public Supplier(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    /**
     * Constructor to initialize a Supplier object without ID.
     *
     * @param name     The name of the supplier.
     * @param location The location of the supplier.
     */
    public Supplier(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and Setters

    /**
     * Gets the ID of the supplier.
     *
     * @return The ID of the supplier.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the supplier.
     *
     * @param id The ID of the supplier.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the supplier.
     *
     * @return The name of the supplier.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the supplier.
     *
     * @param name The name of the supplier.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the location of the supplier.
     *
     * @return The location of the supplier.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the supplier.
     *
     * @param location The location of the supplier.
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
