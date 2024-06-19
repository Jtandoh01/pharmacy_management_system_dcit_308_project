package com.pharmacy;

import com.pharmacy.models.Drug;
import com.pharmacy.models.PurchaseHistory;
import com.pharmacy.models.Supplier;
import com.pharmacy.services.DrugService;
import com.pharmacy.services.PurchaseHistoryService;
import com.pharmacy.services.SupplierService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pharmacy Management System");

        VBox vbox = new VBox();
        Button addDrugButton = new Button("Add Drug");
        Button viewDrugsButton = new Button("View Drugs");
        Button addSupplierButton = new Button("Add Supplier");
        Button viewSuppliersButton = new Button("View Suppliers");
        Button viewPurchaseHistoryButton = new Button("View Purchase History");

        addDrugButton.setOnAction(event -> showAddDrugForm(primaryStage));
        viewDrugsButton.setOnAction(event -> showViewDrugs(primaryStage));
        addSupplierButton.setOnAction(event -> showAddSupplierForm(primaryStage));
        viewSuppliersButton.setOnAction(event -> showViewSuppliers(primaryStage));
        viewPurchaseHistoryButton.setOnAction(event -> showViewPurchaseHistory(primaryStage));

        vbox.getChildren().addAll(addDrugButton, viewDrugsButton, addSupplierButton, viewSuppliersButton, viewPurchaseHistoryButton);

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddDrugForm(Stage primaryStage) {
        VBox vbox = new VBox();
        TextField drugCodeField = new TextField();
        TextField nameField = new TextField();
        TextField descriptionField = new TextField();
        TextField quantityField = new TextField();
        Button submitButton = new Button("Submit");

        drugCodeField.setPromptText("Drug Code");
        nameField.setPromptText("Name");
        descriptionField.setPromptText("Description");
        quantityField.setPromptText("Quantity");

        submitButton.setOnAction(event -> {
            String drugCode = drugCodeField.getText();
            String name = nameField.getText();
            String description = descriptionField.getText();
            int quantity = Integer.parseInt(quantityField.getText());

            DrugService drugService = new DrugService();
            drugService.addDrug(new Drug(drugCode, name, description, quantity));

            primaryStage.setScene(new Scene(new VBox(new Label("Drug added successfully!")), 300, 250));
        });

        vbox.getChildren().addAll(drugCodeField, nameField, descriptionField, quantityField, submitButton);
        primaryStage.setScene(new Scene(vbox, 300, 250));
    }

    private void showViewDrugs(Stage primaryStage) {
        VBox vbox = new VBox();
        DrugService drugService = new DrugService();
        List<Drug> drugs = drugService.getAllDrugs();

        for (Drug drug : drugs) {
            vbox.getChildren().add(new Label(drug.getName() + " - " + drug.getDescription()));
        }

        primaryStage.setScene(new Scene(vbox, 300, 250));
    }

    private void showAddSupplierForm(Stage primaryStage) {
        VBox vbox = new VBox();
        TextField nameField = new TextField();
        TextField locationField = new TextField();
        Button submitButton = new Button("Submit");

        nameField.setPromptText("Name");
        locationField.setPromptText("Location");

        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String location = locationField.getText();

            SupplierService supplierService = new SupplierService();
            supplierService.addSupplier(new Supplier(name, location));

            primaryStage.setScene(new Scene(new VBox(new Label("Supplier added successfully!")), 300, 250));
        });

        vbox.getChildren().addAll(nameField, locationField, submitButton);
        primaryStage.setScene(new Scene(vbox, 300, 250));
    }

    private void showViewSuppliers(Stage primaryStage) {
        VBox vbox = new VBox();
        SupplierService supplierService = new SupplierService();
        List<Supplier> suppliers = supplierService.getAllSuppliers();

        for (Supplier supplier : suppliers) {
            vbox.getChildren().add(new Label(supplier.getName() + " - " + supplier.getLocation()));
        }

        primaryStage.setScene(new Scene(vbox, 300, 250));
    }

    private void showViewPurchaseHistory(Stage primaryStage) {
        VBox vbox = new VBox();
        TextField drugCodeField = new TextField();
        Button searchButton = new Button("Search");

        drugCodeField.setPromptText("Drug Code");

        searchButton.setOnAction(event -> {
            String drugCode = drugCodeField.getText();
            PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
            List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.getPurchaseHistory(drugCode);

            for (PurchaseHistory history : purchaseHistoryList) {
                vbox.getChildren().add(new Label(
                        "Date: " + history.getPurchaseDateTime() +
                        ", Buyer: " + history.getBuyer() +
                        ", Quantity: " + history.getQuantity() +
                        ", Total Amount: " + history.getTotalAmount()
                ));
            }

            primaryStage.setScene(new Scene(vbox, 300, 250));
        });

        vbox.getChildren().addAll(drugCodeField, searchButton);
        primaryStage.setScene(new Scene(vbox, 300, 250));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
