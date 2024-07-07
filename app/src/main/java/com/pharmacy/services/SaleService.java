package com.pharmacy.services;

import com.pharmacy.models.Sale;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleService {

    /**
     * Adds a new sale to the database.
     *
     * @param sale The Sale object to be added.
     */
    public void addSale(Sale sale) {
        String query = "INSERT INTO Sales (drugCode, saleDateTime, quantity, customerId, totalAmount) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, sale.getDrugCode());
            pstmt.setTimestamp(2, Timestamp.valueOf(sale.getDateTime()));
            pstmt.setInt(3, sale.getQuantity());
            pstmt.setInt(4, sale.getCustomerId());
            pstmt.setDouble(5, sale.getTotalAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a list of sales from the database based on the drug code.
     *
     * @param drugCode The code of the drug to filter sales by.
     * @return A list of Sale objects.
     */
    public List<Sale> getSalesByDrugCode(String drugCode) {
        List<Sale> sales = new ArrayList<>();
        String query = "SELECT * FROM Sales WHERE drugCode = ? ORDER BY saleDateTime DESC";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sales.add(new Sale(
                        rs.getInt("id"),
                        rs.getString("drugCode"),
                        rs.getTimestamp("saleDateTime").toLocalDateTime(),
                        rs.getInt("quantity"),
                        rs.getInt("customerId"),
                        rs.getDouble("totalAmount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }
}
