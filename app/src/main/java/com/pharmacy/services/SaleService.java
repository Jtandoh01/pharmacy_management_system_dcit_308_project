// package com.pharmacy.services;

// import com.pharmacy.models.Sale;
// import com.pharmacy.models.Drug;
// import com.pharmacy.models.Customer;
// import com.pharmacy.utils.Database;

// import java.sql.*;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// public class SaleService {
//     public void addSale(Sale sale) {
//         try (Connection connection = Database.getConnection()) {
//             String query = "INSERT INTO Sales (drug_id, quantity, total_amount, sale_date, customer_id) VALUES (?, ?, ?, ?, ?)";
//             try (PreparedStatement statement = connection.prepareStatement(query)) {
//                 statement.setInt(1, sale.getDrug().getId());
//                 statement.setInt(2, sale.getQuantity());
//                 statement.setDouble(3, sale.getTotalAmount());
//                 statement.setTimestamp(4, Timestamp.valueOf(sale.getSaleDate()));
//                 statement.setInt(5, sale.getCustomer().getId());
//                 statement.executeUpdate();
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public List<Sale> getSalesByDrug(int drugId) {
//         List<Sale> sales = new ArrayList<>();
//         try (Connection connection = Database.getConnection()) {
//             String query = "SELECT * FROM Sales WHERE drug_id = ?";
//             try (PreparedStatement statement = connection.prepareStatement(query)) {
//                 statement.setInt(1, drugId);
//                 ResultSet resultSet = statement.executeQuery();
//                 while (resultSet.next()) {
//                     int id = resultSet.getInt("id");
//                     int quantity = resultSet.getInt("quantity");
//                     double totalAmount = resultSet.getDouble("total_amount");
//                     LocalDateTime saleDate = resultSet.getTimestamp("sale_date").toLocalDateTime();
//                     int customerId = resultSet.getInt("customer_id");
//                     Customer customer = new CustomerService().getCustomerById(customerId);
//                     Drug drug = new DrugService().getDrugById(drugId);
//                     sales.add(new Sale(id, drug, quantity, totalAmount, saleDate, customer));
//                 }
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return sales;
//     }
// }
package com.pharmacy.services;

import com.pharmacy.models.Sale;
import com.pharmacy.models.Drug;
import com.pharmacy.models.Customer;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleService {
    public void addSale(Sale sale) {
        try (Connection connection = Database.getConnection()) {
            String query = "INSERT INTO Sales (drugCode, quantity, totalAmount, saleDate, customerId) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, sale.getDrug().getDrugCode());
                statement.setInt(2, sale.getQuantity());
                statement.setDouble(3, sale.getTotalAmount());
                statement.setTimestamp(4, Timestamp.valueOf(sale.getSaleDate()));
                statement.setInt(5, sale.getCustomer().getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sale> getSalesByDrug(String drugCode) {
        List<Sale> sales = new ArrayList<>();
        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM Sales WHERE drugCode = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, drugCode);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int quantity = resultSet.getInt("quantity");
                    double totalAmount = resultSet.getDouble("totalAmount");
                    LocalDateTime saleDate = resultSet.getTimestamp("saleDate").toLocalDateTime();
                    int customerId = resultSet.getInt("customerId");
                    Customer customer = new CustomerService().getCustomerById(customerId);
                    Drug drug = new DrugService().getDrugByCode(drugCode);
                    sales.add(new Sale(id, drug, quantity, totalAmount, saleDate, customer));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }
}
