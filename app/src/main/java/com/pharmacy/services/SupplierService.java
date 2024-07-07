
package com.pharmacy.services;

import com.pharmacy.models.Supplier;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierService {

    /**
     * Adds a new supplier to the database.
     *
     * @param supplier The Supplier object to be added.
     */
    public void addSupplier(Supplier supplier) {
        String query = "INSERT INTO Suppliers (name, location) VALUES (?, ?)";
        try (Connection connection = Database.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, supplier.getName());
                statement.setString(2, supplier.getLocation());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for suppliers by their location.
     *
     * @param location The location to search for suppliers.
     * @return A list of Supplier objects matching the location.
     */
    public List<Supplier> searchSuppliersByLocation(String location) {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM Suppliers WHERE location = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, location);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                suppliers.add(new Supplier(rs.getString("name"), rs.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    /**
     * Retrieves all suppliers from the database.
     *
     * @return A list of Supplier objects.
     */
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM Suppliers";
        try (Connection conn = Database.getDataSource().getConnection()) {
            if (conn != null) {
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        suppliers.add(new Supplier(rs.getInt("id"), rs.getString("name"), rs.getString("location")));
                    }
                }
            } else {
                System.err.println("Failed to make connection to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    /**
     * Updates an existing supplier in the database.
     *
     * @param supplier The Supplier object containing updated information.
     */
    public void updateSupplier(Supplier supplier) {
        String query = "UPDATE Suppliers SET name = ?, location = ? WHERE id = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getLocation());
            pstmt.setInt(3, supplier.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a supplier from the database based on their ID.
     *
     * @param id The ID of the supplier to be deleted.
     */
    public void deleteSupplier(int id) {
        String query = "DELETE FROM Suppliers WHERE id = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
