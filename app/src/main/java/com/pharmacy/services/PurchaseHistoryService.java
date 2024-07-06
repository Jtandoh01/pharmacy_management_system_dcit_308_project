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

    // public List<PurchaseHistory> getPurchaseHistory(String drugCode) {
    //     List<PurchaseHistory> historyList = new ArrayList<>();
    //     String query = "SELECT * FROM PurchaseHistory WHERE drugCode = ? ORDER BY purchaseDateTime DESC";
    //     try (Connection conn = Database.getDataSource().getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(query)) {
    //         pstmt.setString(1, drugCode);
    //         ResultSet rs = pstmt.executeQuery();
    //         while (rs.next()) {
    //             historyList.add(new PurchaseHistory(
    //                     rs.getInt("id"),
    //                     rs.getTimestamp("purchaseDateTime").toLocalDateTime(),
    //                     rs.getString("drugCode"),
    //                     rs.getString("buyer"),
    //                     rs.getInt("customerId"),
    //                     rs.getInt("quantity"),
    //                     rs.getDouble("totalAmount")
    //             ));
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
        
        
    // }

    public List<PurchaseHistory> getPurchaseHistory(String drugCode) {
        List<PurchaseHistory> historyList = new ArrayList<>();
        String query = "SELECT * FROM PurchaseHistory WHERE drugCode = ? ORDER BY purchaseDateTime DESC";
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
            PurchaseHistory history = new PurchaseHistory(
                sale.getId(),
                sale.getDateTime(),
                sale.getDrugCode (),
                "",  // Buyer is not specified in Sales, so we leave it empty or can use a placeholder
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
}
