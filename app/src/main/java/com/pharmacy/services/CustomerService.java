package com.pharmacy.services;

import com.pharmacy.models.Customer;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public void addCustomer(Customer customer) {
        try (Connection connection = Database.getDataSource().getConnection()) {
            String query = "INSERT INTO Customers (name, contact, address) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, customer.getName());
                statement.setString(2, customer.getContact());
                statement.setString(3, customer.getAddress());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = Database.getDataSource().getConnection()) {
            String query = "SELECT * FROM Customers WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String contact = resultSet.getString("contact");
                    String address = resultSet.getString("address");
                    System.out.println("Executing query: " + statement);
                    customer = new Customer(id, name, contact, address);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting customer: " + e.getMessage());
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers";
        try (Connection connection = Database.getDataSource().getConnection()) {
            if (connection != null) {
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String contact = resultSet.getString("contact");
                        String address = resultSet.getString("address");
                        customers.add(new Customer(id, name, contact, address));
                    }
                }
            } else {
                System.err.println("Failed to make connection to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    
}
