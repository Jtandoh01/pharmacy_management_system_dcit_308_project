package com.pharmacy.services;

import com.pharmacy.models.Drug;
import com.pharmacy.models.Supplier;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrugService {
    public void addDrug(Drug drug) {
        String query = "INSERT INTO Drugs (drugCode, name, description, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drug.getDrugCode());
            pstmt.setString(2, drug.getName());
            pstmt.setString(3, drug.getDescription());
            pstmt.setInt(4, drug.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Drug getDrugByCode(String drugCode) {
        Drug drug = null;
        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM Drugs WHERE drugCode = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, drugCode);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int quantity = resultSet.getInt("quantity");
                    drug = new Drug(drugCode, name, description, quantity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drug;
    }

    public void addDrugSupplier(String drugCode, int supplierId) {
        String query = "INSERT INTO DrugSuppliers (drugCode, supplierId) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            pstmt.setInt(2, supplierId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Drug searchDrug(String drugCode) {
        String query = "SELECT * FROM Drugs WHERE drugCode = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Drug(rs.getString("drugCode"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Drug> getAllDrugs() {
        List<Drug> drugs = new ArrayList<>();
        String query = "SELECT * FROM Drugs";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                drugs.add(new Drug(rs.getString("drugCode"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public void updateDrug(Drug drug) {
        String query = "UPDATE Drugs SET name = ?, description = ?, quantity = ? WHERE drugCode = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drug.getName());
            pstmt.setString(2, drug.getDescription());
            pstmt.setInt(3, drug.getQuantity());
            pstmt.setString(4, drug.getDrugCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDrug(String drugCode) {
        String query = "DELETE FROM Drugs WHERE drugCode = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, drugCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStock(String drugCode, int quantity) {
        String query = "UPDATE Drugs SET quantity = quantity + ? WHERE drugCode = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, quantity);
            pstmt.setString(2, drugCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkStockLevels() {
        String query = "SELECT * FROM Drugs WHERE quantity < ?";
        int threshold = 10; // Example threshold value
        try (Connection conn = Database.getConnection();
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

    public List<Supplier> getSuppliersForDrug(String drugCode) {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT Suppliers.* FROM Suppliers INNER JOIN DrugSuppliers ON Suppliers.id = DrugSuppliers.supplierId WHERE DrugSuppliers.drugCode = ?";
        try (Connection conn = Database.getConnection();
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
}

//SECOND

// package com.pharmacy.services;

// import com.pharmacy.models.Drug;
// import com.pharmacy.models.Supplier;
// import com.pharmacy.utils.Database;

// import java.sql.*;
// import java.util.ArrayList;
// import java.util.List;

// public class DrugService {

//     // Method to add a new drug to the database
//     public void addDrug(Drug drug) {
//         String query = "INSERT INTO Drugs (drugCode, name, description, quantity) VALUES (?, ?, ?, ?)";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drug.getDrugCode());
//             pstmt.setString(2, drug.getName());
//             pstmt.setString(3, drug.getDescription());
//             pstmt.setInt(4, drug.getQuantity());
//             pstmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to link a drug with a supplier
//     public void addDrugSupplier(String drugCode, int supplierId) {
//         String query = "INSERT INTO DrugSuppliers (drugCode, supplierId) VALUES (?, ?)";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             pstmt.setInt(2, supplierId);
//             pstmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to search for a drug by its code
//     public Drug searchDrug(String drugCode) {
//         String query = "SELECT * FROM Drugs WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             ResultSet rs = pstmt.executeQuery();
//             if (rs.next()) {
//                 return new Drug(rs.getString("drugCode"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return null;
//     }

//     // Method to retrieve all drugs from the database
//     public List<Drug> getAllDrugs() {
//         List<Drug> drugs = new ArrayList<>();
//         String query = "SELECT * FROM Drugs";
//         try (Connection conn = Database.getConnection();
//              Statement stmt = conn.createStatement();
//              ResultSet rs = stmt.executeQuery(query)) {
//             while (rs.next()) {
//                 drugs.add(new Drug(rs.getString("drugCode"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity")));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return drugs;
//     }

//     // Method to update drug details
//     public void updateDrug(Drug drug) {
//         String query = "UPDATE Drugs SET name = ?, description = ?, quantity = ? WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drug.getName());
//             pstmt.setString(2, drug.getDescription());
//             pstmt.setInt(3, drug.getQuantity());
//             pstmt.setString(4, drug.getDrugCode());
//             pstmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to delete a drug from the database
//     public void deleteDrug(String drugCode) {
//         String query = "DELETE FROM Drugs WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             pstmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to update the stock quantity of a drug
//     public void updateStock(String drugCode, int quantity) {
//         String query = "UPDATE Drugs SET quantity = quantity + ? WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setInt(1, quantity);
//             pstmt.setString(2, drugCode);
//             pstmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to check and print drugs that are low on stock
//     public void checkStockLevels() {
//         String query = "SELECT * FROM Drugs WHERE quantity < ?";
//         int threshold = 10; // Example threshold value
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setInt(1, threshold);
//             ResultSet rs = pstmt.executeQuery();
//             while (rs.next()) {
//                 System.out.println("Drug " + rs.getString("name") + " is low on stock: " + rs.getInt("quantity"));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to get the list of suppliers for a specific drug
//     public List<Supplier> getSuppliersForDrug(String drugCode) {
//         List<Supplier> suppliers = new ArrayList<>();
//         String query = "SELECT Suppliers.* FROM Suppliers INNER JOIN DrugSuppliers ON Suppliers.id = DrugSuppliers.supplierId WHERE DrugSuppliers.drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             ResultSet rs = pstmt.executeQuery();
//             while (rs.next()) {
//                 suppliers.add(new Supplier(rs.getInt("id"), rs.getString("name"), rs.getString("location")));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return suppliers;
//     }
// }

// package com.pharmacy.services;

// import com.pharmacy.models.Drug;
// import com.pharmacy.models.Supplier;
// import com.pharmacy.utils.Database;

// import java.sql.*;
// import java.util.ArrayList;
// import java.util.List;

// public class DrugService {

//     // Method to add a new drug to the database
//     public void addDrug(Drug drug) throws SQLException {
//         String query = "INSERT INTO Drugs (drugCode, name, description, quantity) VALUES (?, ?, ?, ?)";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drug.getDrugCode());
//             pstmt.setString(2, drug.getName());
//             pstmt.setString(3, drug.getDescription());
//             pstmt.setInt(4, drug.getQuantity());
//             pstmt.executeUpdate();
//         }
//     }

//     // Method to link a drug with a supplier
//     public void addDrugSupplier(String drugCode, int supplierId) throws SQLException {
//         String query = "INSERT INTO DrugSuppliers (drugCode, supplierId) VALUES (?, ?)";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             pstmt.setInt(2, supplierId);
//             pstmt.executeUpdate();
//         }
//     }

//     // Method to search for a drug by its code
//     public Drug searchDrug(String drugCode) throws SQLException {
//         String query = "SELECT * FROM Drugs WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             ResultSet rs = pstmt.executeQuery();
//             if (rs.next()) {
//                 return new Drug(rs.getString("drugCode"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"));
//             }
//         }
//         return null;
//     }

//     // Method to retrieve all drugs from the database
//     public List<Drug> getAllDrugs() throws SQLException {
//         List<Drug> drugs = new ArrayList<>();
//         String query = "SELECT * FROM Drugs";
//         try (Connection conn = Database.getConnection();
//              Statement stmt = conn.createStatement();
//              ResultSet rs = stmt.executeQuery(query)) {
//             while (rs.next()) {
//                 drugs.add(new Drug(rs.getString("drugCode"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity")));
//             }
//         }
//         return drugs;
//     }

//     // Method to update drug details
//     public void updateDrug(Drug drug) throws SQLException {
//         String query = "UPDATE Drugs SET name = ?, description = ?, quantity = ? WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drug.getName());
//             pstmt.setString(2, drug.getDescription());
//             pstmt.setInt(3, drug.getQuantity());
//             pstmt.setString(4, drug.getDrugCode());
//             pstmt.executeUpdate();
//         }
//     }

//     // Method to delete a drug from the database
//     public void deleteDrug(String drugCode) throws SQLException {
//         String query = "DELETE FROM Drugs WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             pstmt.executeUpdate();
//         }
//     }

//     // Method to update the stock quantity of a drug
//     public void updateStock(String drugCode, int quantity) throws SQLException {
//         String query = "UPDATE Drugs SET quantity = quantity + ? WHERE drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setInt(1, quantity);
//             pstmt.setString(2, drugCode);
//             pstmt.executeUpdate();
//         }
//     }

//     // Method to check and print drugs that are low on stock
//     public void checkStockLevels() throws SQLException {
//         String query = "SELECT * FROM Drugs WHERE quantity < ?";
//         int threshold = 10; // Example threshold value
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setInt(1, threshold);
//             ResultSet rs = pstmt.executeQuery();
//             while (rs.next()) {
//                 System.out.println("Drug " + rs.getString("name") + " is low on stock: " + rs.getInt("quantity"));
//             }
//         }
//     }

//     // Method to get the list of suppliers for a specific drug
//     public List<Supplier> getSuppliersForDrug(String drugCode) throws SQLException {
//         List<Supplier> suppliers = new ArrayList<>();
//         String query = "SELECT Suppliers.* FROM Suppliers INNER JOIN DrugSuppliers ON Suppliers.id = DrugSuppliers.supplierId WHERE DrugSuppliers.drugCode = ?";
//         try (Connection conn = Database.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, drugCode);
//             ResultSet rs = pstmt.executeQuery();
//             while (rs.next()) {
//                 suppliers.add(new Supplier(rs.getInt("id"), rs.getString("name"), rs.getString("location")));
//             }
//         }
//         return suppliers;
//     }
// }

