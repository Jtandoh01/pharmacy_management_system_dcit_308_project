package com.pharmacy.services;

import com.pharmacy.models.Customer;
import com.pharmacy.models.Drug;
import com.pharmacy.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public void addCustomer(Customer customer) {
        try (Connection connection = Database.getConnection()) {
            String query = "INSERT INTO Customers (name, contactnumber, address) VALUES (?, ?, ?)";
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
        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM Customers WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String contact = resultSet.getString("contactnumber");
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
        try (Connection connection = Database.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    // int id = resultSet.getInt("id");
                    // String name = resultSet.getString("name");
                    // String contact = resultSet.getString("contactnumber");
                    // String address = resultSet.getString("address");
                    // //System.out.println("Executing query: " + statement);
                    // customers.add(new Customer(id, name, contact, address));
                    customers.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("contactnumber"), rs.getString("address")));
                }
            }
        } catch (SQLException e) {
            //System.err.println("Error adding customer: " + e.getMessage());
            e.printStackTrace();
        }
        return customers;
    }
}
