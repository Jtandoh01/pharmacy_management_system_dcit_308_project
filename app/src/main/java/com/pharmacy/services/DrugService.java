
package com.pharmacy.services;

import com.pharmacy.models.Drug;
import com.pharmacy.models.Supplier;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrugService {

    /**
     * Adds a new drug to the database.
     *
     * @param drug The Drug object to be added.
     */
    public void addDrug(Drug drug) {
        String query = "INSERT INTO Drugs (drugCode, name, description, quantity, price) VALUES (?, ?, ?, ?,?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drug.getDrugCode());
            pstmt.setString(2, drug.getName());
            pstmt.setString(3, drug.getDescription());
            pstmt.setInt(4, drug.getQuantity());
            pstmt.setFloat(5, drug.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a drug from the database based on its drug code.
     *
     * @param drugCode The code of the drug to be retrieved.
     * @return The Drug object if found, otherwise null.
     */
    public Drug getDrugByCode(String drugCode) {
        Drug drug = null;
        try (Connection connection = Database.getDataSource().getConnection()) {
            String query = "SELECT * FROM Drugs WHERE drugCode = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, drugCode);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int quantity = resultSet.getInt("quantity");
                    Float price = resultSet.getFloat("price");
                    drug = new Drug(drugCode, name, description, quantity, price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drug;
    }

    /**
     * Adds a supplier to a drug in the database.
     *
     * @param drugCode The code of the drug to which the supplier is to be added.
     * @param supplier The Supplier object to be added.
     */
    public void addSupplierToDrug(String drugCode, Supplier supplier) {
        try (Connection connection = Database.getDataSource().getConnection()) {
            // Insert supplier if not already in database
            String supplierQuery = "INSERT INTO suppliers (name, location) VALUES (?, ?) ON CONFLICT(name, location) DO NOTHING";
            PreparedStatement supplierStatement = connection.prepareStatement(supplierQuery);
            supplierStatement.setString(1, supplier.getName());
            supplierStatement.setString(2, supplier.getLocation());
            supplierStatement.executeUpdate();

            // Get supplier ID
            String getSupplierIdQuery = "SELECT id FROM suppliers WHERE name = ? AND location = ?";
            PreparedStatement getSupplierIdStatement = connection.prepareStatement(getSupplierIdQuery);
            getSupplierIdStatement.setString(1, supplier.getName());
            getSupplierIdStatement.setString(2, supplier.getLocation());
            ResultSet supplierResultSet = getSupplierIdStatement.executeQuery();
            int supplierId = supplierResultSet.next() ? supplierResultSet.getInt("id") : -1;

            if (supplierId != -1) {
                // Link drug and supplier
                String linkQuery = "INSERT INTO drugsuppliers (drugCode, supplierId) VALUES (?, ?)";
                PreparedStatement linkStatement = connection.prepareStatement(linkQuery);
                linkStatement.setString(1, drugCode);
                linkStatement.setInt(2, supplierId);
                linkStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new drug along with its suppliers to the database.
     *
     * @param drug      The Drug object to be added.
     * @param suppliers The list of Supplier objects to be added for the drug.
     */
    public void addDrugWithSuppliers(Drug drug, List<Supplier> suppliers) {
        try (Connection connection = Database.getDataSource().getConnection()) {
            // Insert the drug
            String drugQuery = "INSERT INTO Drugs (drugCode, name, description, quantity, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement drugStatement = connection.prepareStatement(drugQuery);
            drugStatement.setString(1, drug.getDrugCode());
            drugStatement.setString(2, drug.getName());
            drugStatement.setString(3, drug.getDescription());
            drugStatement.setInt(4, drug.getQuantity());
            drugStatement.setDouble(5, drug.getPrice());
            drugStatement.executeUpdate();

            // Link the suppliers
            for (Supplier supplier : suppliers) {
                addSupplierToDrug(drug.getDrugCode(), supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for a drug by its code.
     *
     * @param drugCode The code of the drug to be searched.
     * @return The Drug object if found, otherwise null.
     */
    public Drug searchDrug(String drugCode) {
        String query = "SELECT * FROM Drugs WHERE drugCode = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Drug(rs.getString("drugCode"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"), rs.getFloat("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves all drugs from the database.
     *
     * @return A list of Drug objects.
     */
    public List<Drug> getAllDrugs() {
        List<Drug> drugs = new ArrayList<>();
        try (Connection connection = Database.getDataSource().getConnection()) {
            String query = "SELECT * FROM Drugs";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Drug drug = new Drug(
                        resultSet.getString("drugCode"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("price")
                );

                // Get suppliers for each drug
                String supplierQuery = "SELECT s.id, s.name, s.location FROM Suppliers s " +
                        "JOIN DrugSuppliers ds ON s.id = ds.supplierId " +
                        "WHERE ds.drugCode = ?";
                PreparedStatement supplierStatement = connection.prepareStatement(supplierQuery);
                supplierStatement.setString(1, drug.getDrugCode());
                ResultSet supplierResultSet = supplierStatement.executeQuery();
                List<Supplier> suppliers = new ArrayList<>();
                while (supplierResultSet.next()) {
                    Supplier supplier = new Supplier(
                            supplierResultSet.getInt("id"),
                            supplierResultSet.getString("name"),
                            supplierResultSet.getString("location")

                    );
                    suppliers.add(supplier);
                }
                drug.setSuppliers(suppliers);

                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    /**
     * Updates an existing drug in the database.
     *
     * @param drug The Drug object containing updated information.
     */
    public void updateDrug(Drug drug) {
        String query = "UPDATE Drugs SET name = ?, description = ?, quantity = ? , price = ? WHERE drugCode = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drug.getName());
            pstmt.setString(2, drug.getDescription());
            pstmt.setInt(3, drug.getQuantity());
            pstmt.setFloat(4, drug.getPrice());
            pstmt.setString(5, drug.getDrugCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a drug from the database based on its code.
     *
     * @param drugCode The code of the drug to be deleted.
     */
    public void deleteDrug(String drugCode) {
        String query = "DELETE FROM Drugs WHERE drugCode = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the stock quantity of a drug in the database.
     *
     * @param drugCode The code of the drug to be updated.
     * @param quantity The quantity to be added to the current stock.
     */
    public void updateStock(String drugCode, int quantity) {
        String query = "UPDATE Drugs SET quantity = quantity + ? WHERE drugCode = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, quantity);
            pstmt.setString(2, drugCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks the stock levels of all drugs and prints those that are below```java
     * a predefined threshold.
     */
    public void checkStockLevels() {
        String query = "SELECT * FROM Drugs WHERE quantity < ?";
        int threshold = 10; // Example threshold value
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, threshold);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Drug " + rs.getString("name") + " is low on stock: " + rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the list of suppliers for a specific drug.
     *
     * @param drugCode The code of the drug whose suppliers are to be retrieved.
     * @return A list of Supplier objects.
     */
    public List<Supplier> getSuppliersForDrug(String drugCode) {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT Suppliers.* FROM Suppliers INNER JOIN DrugSuppliers ON Suppliers.id = DrugSuppliers.supplierId WHERE DrugSuppliers.drugCode = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                suppliers.add(new Supplier(rs.getInt("id"), rs.getString("name"), rs.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    /**
     * Searches for suppliers based on their location.
     *
     * @param location The location to search for suppliers.
     * @return A list of Supplier objects matching the location.
     */
    public List<Supplier> searchSuppliers(String location) {
        List<Supplier> matchingSuppliers = new ArrayList<>();
        try (Connection connection = Database.getDataSource().getConnection()) {
            String query = "SELECT * FROM suppliers WHERE location = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, location);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                matchingSuppliers.add(new Supplier(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchingSuppliers;
    }
}
