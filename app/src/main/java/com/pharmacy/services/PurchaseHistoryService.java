package com.pharmacy.services;

import com.pharmacy.models.PurchaseHistory;
import com.pharmacy.models.Sale;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryService {

    public void addPurchaseHistory(PurchaseHistory history) {
        String query = "INSERT INTO PurchaseHistory (drugCode, purchaseDateTime, buyer, customerId ,quantity, totalAmount) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, history.getDrugCode ());
            pstmt.setTimestamp(2, Timestamp.valueOf(history.getPurchaseDateTime()));
            pstmt.setString(3, history.getBuyer());
            pstmt.setInt(4, history.getCustomerId());
            pstmt.setInt(5, history.getQuantity());
            pstmt.setDouble(6, history.getTotalAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public List<PurchaseHistory> getPurchaseHistory(String drugCode) {
        List<PurchaseHistory> historyList = new ArrayList<>();
        String query = "SELECT ph.id,ph.purchaseDateTime, ph.drugCode, c.name AS buyer, ph.customerId, ph.quantity, ph.totalAmount " + "FROM PurchaseHistory ph " + "LEFT JOIN Customers c ON ph.customerId = c.id " + "WHERE ph.drugCode = ? " + "ORDER BY ph.purchaseDateTime DESC";
        
        //"SELECT * FROM PurchaseHistory WHERE drugCode = ? ORDER BY purchaseDateTime DESC";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                historyList.add(new PurchaseHistory(
                        rs.getInt("id"),
                        rs.getTimestamp("purchaseDateTime").toLocalDateTime(),
                        rs.getString("drugCode"),
                        rs.getString("buyer"),
                        rs.getInt("customerId"),
                        rs.getInt("quantity"),
                        rs.getDouble("totalAmount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add sales records to the purchase history list
        SaleService saleService = new SaleService();
        List<Sale> salesList = saleService.getSalesByDrugCode(drugCode);
        for (Sale sale : salesList) {
            String customerName = getCustomerNameById(sale.getCustomerId());
            PurchaseHistory history = new PurchaseHistory(
                sale.getId(),
                sale.getDateTime(),
                sale.getDrugCode (),
                customerName,
                sale.getCustomerId(),
                sale.getQuantity(),
                sale.getTotalAmount()
            );
            historyList.add(history);
        }

        // Optionally sort the combined list by date, if not already sorted
        historyList.sort((h1, h2) -> h2.getPurchaseDateTime().compareTo(h1.getPurchaseDateTime()));

        return historyList;
    }

    

    public void deletePurchaseHistory(int id) {
        String query = "DELETE FROM PurchaseHistory WHERE id = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String getCustomerNameById(int customerId) {
        String query = "SELECT name FROM Customers WHERE id = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
