// package com.pharmacy;

// import com.pharmacy.models.Drug;
// import com.pharmacy.models.PurchaseHistory;
// import com.pharmacy.models.Supplier;
// import com.pharmacy.services.DrugService;
// import com.pharmacy.services.PurchaseHistoryService;
// import com.pharmacy.services.SupplierService;
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
// import javafx.application.Application;


// import java.time.LocalDateTime;
// import java.util.List;

// public class Main extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("com.pharmacy Management System");

//         VBox vbox = new VBox();
//         Button addDrugButton = new Button("Add Drug");
//         Button viewDrugsButton = new Button("View Drugs");
//         Button addSupplierButton = new Button("Add Supplier");
//         Button viewSuppliersButton = new Button("View Suppliers");
//         Button viewPurchaseHistoryButton = new Button("View Purchase History");

//         addDrugButton.setOnAction(event -> showAddDrugForm(primaryStage));
//         viewDrugsButton.setOnAction(event -> showViewDrugs(primaryStage));
//         addSupplierButton.setOnAction(event -> showAddSupplierForm(primaryStage));
//         viewSuppliersButton.setOnAction(event -> showViewSuppliers(primaryStage));
//         viewPurchaseHistoryButton.setOnAction(event -> showViewPurchaseHistory(primaryStage));

//         vbox.getChildren().addAll(addDrugButton, viewDrugsButton, addSupplierButton, viewSuppliersButton, viewPurchaseHistoryButton);

//         Scene scene = new Scene(vbox, 300, 250);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     private void showAddDrugForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField drugCodeField = new TextField();
//         TextField nameField = new TextField();
//         TextField descriptionField = new TextField();
//         TextField quantityField = new TextField();
//         Button submitButton = new Button("Submit");

//         drugCodeField.setPromptText("Drug Code");
//         nameField.setPromptText("Name");
//         descriptionField.setPromptText("Description");
//         quantityField.setPromptText("Quantity");

//         submitButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             String name = nameField.getText();
//             String description = descriptionField.getText();
//             int quantity = Integer.parseInt(quantityField.getText());

//             DrugService drugService = new DrugService();
//             drugService.addDrug(new Drug(drugCode, name, description, quantity));

//             primaryStage.setScene(new Scene(new VBox(new Label("Drug added successfully!")), 300, 250));
//         });

//         vbox.getChildren().addAll(drugCodeField, nameField, descriptionField, quantityField, submitButton);
//         primaryStage.setScene(new Scene(vbox, 300, 250));
//     }

//     private void showViewDrugs(Stage primaryStage) {
//         VBox vbox = new VBox();
//         DrugService drugService = new DrugService();
//         List<Drug> drugs = drugService.getAllDrugs();

//         for (Drug drug : drugs) {
//             vbox.getChildren().add(new Label(drug.getName() + " - " + drug.getDescription()));
//         }

//         primaryStage.setScene(new Scene(vbox, 300, 250));
//     }

//     private void showAddSupplierForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField nameField = new TextField();
//         TextField locationField = new TextField();
//         Button submitButton = new Button("Submit");

//         nameField.setPromptText("Name");
//         locationField.setPromptText("Location");

//         submitButton.setOnAction(event -> {
//             String name = nameField.getText();
//             String location = locationField.getText();

//             SupplierService supplierService = new SupplierService();
//             supplierService.addSupplier(new Supplier(name, location));

//             primaryStage.setScene(new Scene(new VBox(new Label("Supplier added successfully!")), 300, 250));
//         });

//         vbox.getChildren().addAll(nameField, locationField, submitButton);
//         primaryStage.setScene(new Scene(vbox, 300, 250));
//     }

//     private void showViewSuppliers(Stage primaryStage) {
//         VBox vbox = new VBox();
//         SupplierService supplierService = new SupplierService();
//         List<Supplier> suppliers = supplierService.getAllSuppliers();

//         for (Supplier supplier : suppliers) {
//             vbox.getChildren().add(new Label(supplier.getName() + " - " + supplier.getLocation()));
//         }

//         primaryStage.setScene(new Scene(vbox, 300, 250));
//     }

//     private void showViewPurchaseHistory(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField drugCodeField = new TextField();
//         Button searchButton = new Button("Search");

//         drugCodeField.setPromptText("Drug Code");

//         searchButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
//             List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.getPurchaseHistory(drugCode);

//             for (PurchaseHistory history : purchaseHistoryList) {
//                 vbox.getChildren().add(new Label(
//                         "Date: " + history.getPurchaseDateTime() +
//                         ", Buyer: " + history.getBuyer() +
//                         ", Quantity: " + history.getQuantity() +
//                         ", Total Amount: " + history.getTotalAmount()
//                 ));
//             }

//             primaryStage.setScene(new Scene(vbox, 300, 250));
//         });

//         vbox.getChildren().addAll(drugCodeField, searchButton);
//         primaryStage.setScene(new Scene(vbox, 300, 250));
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

//SECOND
// package com.pharmacy;

// import com.pharmacy.models.Drug;
// import com.pharmacy.models.PurchaseHistory;
// import com.pharmacy.models.Supplier;
// import com.pharmacy.services.DrugService;
// import com.pharmacy.services.PurchaseHistoryService;
// import com.pharmacy.services.SupplierService;
// import com.pharmacy.utils.BackButtonHandler;
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// import java.time.LocalDateTime;
// import java.util.List;

// public class Main extends Application {
//     private BackButtonHandler backButtonHandler;

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Pharmacy Management System");
//         backButtonHandler = BackButtonHandler.getInstance(primaryStage);

//         VBox vbox = new VBox();
//         Button addDrugButton = new Button("Add Drug");
//         Button viewDrugsButton = new Button("View Drugs");
//         Button addSupplierButton = new Button("Add Supplier");
//         Button viewSuppliersButton = new Button("View Suppliers");
//         Button viewPurchaseHistoryButton = new Button("View Purchase History");

//         addDrugButton.setOnAction(event -> showAddDrugForm(primaryStage));
//         viewDrugsButton.setOnAction(event -> showViewDrugs(primaryStage));
//         addSupplierButton.setOnAction(event -> showAddSupplierForm(primaryStage));
//         viewSuppliersButton.setOnAction(event -> showViewSuppliers(primaryStage));
//         viewPurchaseHistoryButton.setOnAction(event -> showViewPurchaseHistory(primaryStage));

//         vbox.getChildren().addAll(addDrugButton, viewDrugsButton, addSupplierButton, viewSuppliersButton, viewPurchaseHistoryButton);

//         Scene scene = new Scene(vbox, 300, 250);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     private void showAddDrugForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField drugCodeField = new TextField();
//         TextField nameField = new TextField();
//         TextField descriptionField = new TextField();
//         TextField quantityField = new TextField();
//         Button submitButton = new Button("Submit");
//         Button backButton = new Button("Back");

//         drugCodeField.setPromptText("Drug Code");
//         nameField.setPromptText("Name");
//         descriptionField.setPromptText("Description");
//         quantityField.setPromptText("Quantity");

//         submitButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             String name = nameField.getText();
//             String description = descriptionField.getText();
//             int quantity = Integer.parseInt(quantityField.getText());

//             DrugService drugService = new DrugService();
//             drugService.addDrug(new Drug(drugCode, name, description, quantity));
//             //showViewDrugs(primaryStage); 

//             primaryStage.setScene(new Scene(new VBox(new Label("Drug added successfully!")), 300, 250));
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(drugCodeField, nameField, descriptionField, quantityField, submitButton, backButton);
//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewDrugs(Stage primaryStage) {
//         VBox vbox = new VBox();
//         DrugService drugService = new DrugService();
//         List<Drug> drugs = drugService.getAllDrugs();
//         Button backButton = new Button("Back");

//         for (Drug drug : drugs) {
//             vbox.getChildren().add(new Label(drug.getName() + " - " + drug.getDescription()));
//         }

//         if (drugs.isEmpty()) {
//             vbox.getChildren().add(new Label("No drugs available."));
//         } else {
//             for (Drug drug : drugs) {
//                 vbox.getChildren().add(new Label(drug.getName() + " - " + drug.getDescription()));
//             }
//         }

//         backButton.setOnAction(event -> backButtonHandler.goBack());
//         vbox.getChildren().add(backButton);

//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showAddSupplierForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField nameField = new TextField();
//         TextField locationField = new TextField();
//         Button submitButton = new Button("Submit");
//         Button backButton = new Button("Back");

//         nameField.setPromptText("Name");
//         locationField.setPromptText("Location");

//         submitButton.setOnAction(event -> {
//             String name = nameField.getText();
//             String location = locationField.getText();

//             SupplierService supplierService = new SupplierService();
//             supplierService.addSupplier(new Supplier(name, location));

//             primaryStage.setScene(new Scene(new VBox(new Label("Supplier added successfully!")), 300, 250));
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(nameField, locationField, submitButton, backButton);
//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewSuppliers(Stage primaryStage) {
//         VBox vbox = new VBox();
//         SupplierService supplierService = new SupplierService();
//         List<Supplier> suppliers = supplierService.getAllSuppliers();
//         Button backButton = new Button("Back");

//         for (Supplier supplier : suppliers) {
//             vbox.getChildren().add(new Label(supplier.getName() + " - " + supplier.getLocation()));
//         }


//         if (suppliers.isEmpty()) {
//             vbox.getChildren().add(new Label("No suppliers available."));
//         } else {
//             for (Supplier supplier : suppliers) {
//                 vbox.getChildren().add(new Label(supplier.getName() + " - " + supplier.getLocation()));
//             }
//         }

//         backButton.setOnAction(event -> backButtonHandler.goBack());
//         vbox.getChildren().add(backButton);

//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewPurchaseHistory(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField drugCodeField = new TextField();
//         Button searchButton = new Button("Search");
//         Button backButton = new Button("Back");

//         drugCodeField.setPromptText("Drug Code");

//         searchButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
//             List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.getPurchaseHistory(drugCode);

//             for (PurchaseHistory history : purchaseHistoryList) {
//                 vbox.getChildren().add(new Label(
//                         "Date: " + history.getPurchaseDateTime() +
//                                 ", Buyer: " + history.getBuyer() +
//                                 ", Quantity: " + history.getQuantity() +
//                                 ", Total Amount: " + history.getTotalAmount()
//                 ));
//             }

//             primaryStage.setScene(new Scene(vbox, 300, 250));
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(drugCodeField, searchButton, backButton);
//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

//THIRD

// package com.pharmacy;

// import com.pharmacy.models.Drug;
// import com.pharmacy.models.PurchaseHistory;
// import com.pharmacy.models.Supplier;
// import com.pharmacy.services.DrugService;
// import com.pharmacy.services.PurchaseHistoryService;
// import com.pharmacy.services.SupplierService;
// import com.pharmacy.utils.BackButtonHandler;
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// import java.util.List;

// public class Main extends Application {
//     private BackButtonHandler backButtonHandler;
//     private Scene mainMenuScene;
//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Pharmacy Management System");
//         backButtonHandler = BackButtonHandler.getInstance(primaryStage);

//         VBox vbox = new VBox();
//         Button addDrugButton = new Button("Add Drug");
//         Button viewDrugsButton = new Button("View Drugs");
//         Button addSupplierButton = new Button("Add Supplier");
//         Button viewSuppliersButton = new Button("View Suppliers");
//         Button viewPurchaseHistoryButton = new Button("View Purchase History");

//         addDrugButton.setOnAction(event -> showAddDrugForm(primaryStage));
//         viewDrugsButton.setOnAction(event -> showViewDrugs(primaryStage));
//         addSupplierButton.setOnAction(event -> showAddSupplierForm(primaryStage));
//         viewSuppliersButton.setOnAction(event -> showViewSuppliers(primaryStage));
//         viewPurchaseHistoryButton.setOnAction(event -> showViewPurchaseHistory(primaryStage));

//         vbox.getChildren().addAll(addDrugButton, viewDrugsButton, addSupplierButton, viewSuppliersButton, viewPurchaseHistoryButton);
//         mainMenuScene = new Scene(vbox, 300, 250);
//         primaryStage.setScene(mainMenuScene);
//         primaryStage.show();

//         // Scene scene = new Scene(vbox, 300, 250);
//         // primaryStage.setScene(scene);
//         // primaryStage.show();
//     }

//     private void showAddDrugForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField drugCodeField = new TextField();
//         TextField nameField = new TextField();
//         TextField descriptionField = new TextField();
//         TextField quantityField = new TextField();
//         Button submitButton = new Button("Submit");
//         Button backButton = new Button("Back");

//         drugCodeField.setPromptText("Drug Code");
//         nameField.setPromptText("Name");
//         descriptionField.setPromptText("Description");
//         quantityField.setPromptText("Quantity");

//         submitButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             String name = nameField.getText();
//             String description = descriptionField.getText();
//             int quantity = Integer.parseInt(quantityField.getText());

//             DrugService drugService = new DrugService();
//             drugService.addDrug(new Drug(drugCode, name, description, quantity));

//             showSuccessMessage(primaryStage, "Drug added successfully!");
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(drugCodeField, nameField, descriptionField, quantityField, submitButton, backButton);
//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     // private void showSuccessMessage(Stage primaryStage, String message) {
//     //     VBox vbox = new VBox();
//     //     Label messageLabel = new Label(message);
//     //     Button backButton = new Button("Back");

//     //     backButton.setOnAction(event -> backButtonHandler.goBack());

//     //     vbox.getChildren().addAll(messageLabel, backButton);
//     //     Scene scene = new Scene(vbox, 300, 250);
//     //     backButtonHandler.pushScene(primaryStage.getScene());
//     //     primaryStage.setScene(scene);
//     // }
//     private void showSuccessMessage(Stage primaryStage, String message) {
//         VBox vbox = new VBox();
//         Label messageLabel = new Label(message);
//         Button backButton = new Button("Back");

//         backButton.setOnAction(event -> primaryStage.setScene(mainMenuScene));

//         vbox.getChildren().addAll(messageLabel, backButton);
//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewDrugs(Stage primaryStage) {
//         VBox vbox = new VBox();
//         DrugService drugService = new DrugService();
//         List<Drug> drugs = drugService.getAllDrugs();
//         Button backButton = new Button("Back");

//         if (drugs.isEmpty()) {
//             vbox.getChildren().add(new Label("No drugs available."));
//         } else {
//             for (Drug drug : drugs) {
//                 vbox.getChildren().add(new Label(drug.getName() + " - " + drug.getDescription()));
//             }
//         }

//         backButton.setOnAction(event -> backButtonHandler.goBack());
//         vbox.getChildren().add(backButton);

//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showAddSupplierForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField nameField = new TextField();
//         TextField locationField = new TextField();
//         Button submitButton = new Button("Submit");
//         Button backButton = new Button("Back");

//         nameField.setPromptText("Name");
//         locationField.setPromptText("Location");

//         submitButton.setOnAction(event -> {
//             String name = nameField.getText();
//             String location = locationField.getText();

//             SupplierService supplierService = new SupplierService();
//             supplierService.addSupplier(new Supplier(name, location));

//             showSuccessMessage(primaryStage, "Supplier added successfully!");
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(nameField, locationField, submitButton, backButton);
//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewSuppliers(Stage primaryStage) {
//         VBox vbox = new VBox();
//         SupplierService supplierService = new SupplierService();
//         List<Supplier> suppliers = supplierService.getAllSuppliers();
//         Button backButton = new Button("Back");

//         if (suppliers.isEmpty()) {
//             vbox.getChildren().add(new Label("No suppliers available."));
//         } else {
//             for (Supplier supplier : suppliers) {
//                 vbox.getChildren().add(new Label(supplier.getName() + " - " + supplier.getLocation()));
//             }
//         }

//         backButton.setOnAction(event -> backButtonHandler.goBack());
//         vbox.getChildren().add(backButton);

//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewPurchaseHistory(Stage primaryStage) {
//         VBox vbox = new VBox();
//         TextField drugCodeField = new TextField();
//         Button searchButton = new Button("Search");
//         Button backButton = new Button("Back");

//         drugCodeField.setPromptText("Drug Code");

//         searchButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
//             List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.getPurchaseHistory(drugCode);

//             if (purchaseHistoryList.isEmpty()) {
//                 vbox.getChildren().add(new Label("No purchase history available for this drug."));
//             } else {
//                 for (PurchaseHistory history : purchaseHistoryList) {
//                     vbox.getChildren().add(new Label(
//                             "Date: " + history.getPurchaseDateTime() +
//                                     ", Buyer: " + history.getBuyer() +
//                                     ", Quantity: " + history.getQuantity() +
//                                     ", Total Amount: " + history.getTotalAmount()
//                     ));
//                 }
//             }

//             primaryStage.setScene(new Scene(vbox, 300, 250));
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(drugCodeField, searchButton, backButton);
//         Scene scene = new Scene(vbox, 300, 250);
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }


//FOURTH
// package com.pharmacy;

// import com.pharmacy.models.Drug;
// import com.pharmacy.models.PurchaseHistory;
// import com.pharmacy.models.Supplier;
// import com.pharmacy.services.DrugService;
// import com.pharmacy.services.PurchaseHistoryService;
// import com.pharmacy.services.SupplierService;
// import com.pharmacy.utils.BackButtonHandler;
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// import java.util.List;

// public class Main extends Application {
//     private BackButtonHandler backButtonHandler;
//     private Scene mainMenuScene;

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Pharmacy Management System");
//         backButtonHandler = BackButtonHandler.getInstance(primaryStage);

//         VBox vbox = new VBox();
//         vbox.getStyleClass().add("root");

//         Label titleLabel = new Label("Pharmacy Management System");
//         titleLabel.getStyleClass().add("title");

//         Button addDrugButton = new Button("Add Drug");
//         Button viewDrugsButton = new Button("View Drugs");
//         Button addSupplierButton = new Button("Add Supplier");
//         Button viewSuppliersButton = new Button("View Suppliers");
//         Button viewPurchaseHistoryButton = new Button("View Purchase History");

//         addDrugButton.getStyleClass().add("button");
//         viewDrugsButton.getStyleClass().add("button");
//         addSupplierButton.getStyleClass().add("button");
//         viewSuppliersButton.getStyleClass().add("button");
//         viewPurchaseHistoryButton.getStyleClass().add("button");

//         addDrugButton.setOnAction(event -> showAddDrugForm(primaryStage));
//         viewDrugsButton.setOnAction(event -> showViewDrugs(primaryStage));
//         addSupplierButton.setOnAction(event -> showAddSupplierForm(primaryStage));
//         viewSuppliersButton.setOnAction(event -> showViewSuppliers(primaryStage));
//         viewPurchaseHistoryButton.setOnAction(event -> showViewPurchaseHistory(primaryStage));

//         vbox.getChildren().addAll(titleLabel, addDrugButton, viewDrugsButton, addSupplierButton, viewSuppliersButton, viewPurchaseHistoryButton);

//         mainMenuScene = new Scene(vbox, 400, 350);
//         mainMenuScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//         primaryStage.setScene(mainMenuScene);
//         primaryStage.show();
//     }

//     private void showAddDrugForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         vbox.getStyleClass().add("root");

//         TextField drugCodeField = new TextField();
//         TextField nameField = new TextField();
//         TextField descriptionField = new TextField();
//         TextField quantityField = new TextField();
//         Button submitButton = new Button("Submit");
//         Button backButton = new Button("Back");

//         drugCodeField.setPromptText("Drug Code");
//         nameField.setPromptText("Name");
//         descriptionField.setPromptText("Description");
//         quantityField.setPromptText("Quantity");

//         drugCodeField.getStyleClass().add("text-field");
//         nameField.getStyleClass().add("text-field");
//         descriptionField.getStyleClass().add("text-field");
//         quantityField.getStyleClass().add("text-field");

//         submitButton.getStyleClass().add("button");
//         backButton.getStyleClass().add("button");

//         submitButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             String name = nameField.getText();
//             String description = descriptionField.getText();
//             int quantity = Integer.parseInt(quantityField.getText());

//             DrugService drugService = new DrugService();
//             drugService.addDrug(new Drug(drugCode, name, description, quantity));

//             showSuccessMessage(primaryStage, "Drug added successfully!");
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(drugCodeField, nameField, descriptionField, quantityField, submitButton, backButton);
//         Scene scene = new Scene(vbox, 400, 350);
//         scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showSuccessMessage(Stage primaryStage, String message) {
//         VBox vbox = new VBox();
//         vbox.getStyleClass().add("root");

//         Label messageLabel = new Label(message);
//         messageLabel.getStyleClass().add("label");

//         Button backButton = new Button("Back");
//         backButton.getStyleClass().add("button");

//         backButton.setOnAction(event -> primaryStage.setScene(mainMenuScene));

//         vbox.getChildren().addAll(messageLabel, backButton);
//         Scene scene = new Scene(vbox, 400, 350);
//         scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//         primaryStage.setScene(scene);
//     }

//     private void showViewDrugs(Stage primaryStage) {
//         VBox vbox = new VBox();
//         vbox.getStyleClass().add("root");

//         DrugService drugService = new DrugService();
//         List<Drug> drugs = drugService.getAllDrugs();
//         Button backButton = new Button("Back");
//         backButton.getStyleClass().add("button");

//         if (drugs.isEmpty()) {
//             vbox.getChildren().add(new Label("No drugs available."));
//         } else {
//             for (Drug drug : drugs) {
//                 Label drugLabel = new Label(drug.getName() + " - " + drug.getDescription());
//                 drugLabel.getStyleClass().add("label");
//                 vbox.getChildren().add(drugLabel);
//             }
//         }

//         backButton.setOnAction(event -> backButtonHandler.goBack());
//         vbox.getChildren().add(backButton);

//         Scene scene = new Scene(vbox, 400, 350);
//         scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showAddSupplierForm(Stage primaryStage) {
//         VBox vbox = new VBox();
//         vbox.getStyleClass().add("root");

//         TextField nameField = new TextField();
//         TextField locationField = new TextField();
//         Button submitButton = new Button("Submit");
//         Button backButton = new Button("Back");

//         nameField.setPromptText("Name");
//         locationField.setPromptText("Location");

//         nameField.getStyleClass().add("text-field");
//         locationField.getStyleClass().add("text-field");

//         submitButton.getStyleClass().add("button");
//         backButton.getStyleClass().add("button");

//         submitButton.setOnAction(event -> {
//             String name = nameField.getText();
//             String location = locationField.getText();

//             SupplierService supplierService = new SupplierService();
//             supplierService.addSupplier(new Supplier(name, location));

//             showSuccessMessage(primaryStage, "Supplier added successfully!");
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(nameField, locationField, submitButton, backButton);
//         Scene scene = new Scene(vbox, 400, 350);
//         scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewSuppliers(Stage primaryStage) {
//         VBox vbox = new VBox();
//         vbox.getStyleClass().add("root");

//         SupplierService supplierService = new SupplierService();
//         List<Supplier> suppliers = supplierService.getAllSuppliers();
//         Button backButton = new Button("Back");
//         backButton.getStyleClass().add("button");

//         if (suppliers.isEmpty()) {
//             vbox.getChildren().add(new Label("No suppliers available."));
//         } else {
//             for (Supplier supplier : suppliers) {
//                 Label supplierLabel = new Label(supplier.getName() + " - " + supplier.getLocation());
//                 supplierLabel.getStyleClass().add("label");
//                 vbox.getChildren().add(supplierLabel);
//             }
//         }

//         backButton.setOnAction(event -> backButtonHandler.goBack());
//         vbox.getChildren().add(backButton);

//         Scene scene = new Scene(vbox, 400, 350);
//         scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     private void showViewPurchaseHistory(Stage primaryStage) {
//         VBox vbox = new VBox();
//         vbox.getStyleClass().add("root");

//         TextField drugCodeField = new TextField();
//         Button searchButton = new Button("Search");
//         Button backButton = new Button("Back");

//         drugCodeField.setPromptText("Drug Code");

//         drugCodeField.getStyleClass().add("text-field");
//         searchButton.getStyleClass().add("button");
//         backButton.getStyleClass().add("button");

//         searchButton.setOnAction(event -> {
//             String drugCode = drugCodeField.getText();
//             PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
//             List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.getPurchaseHistory(drugCode);

//             if (purchaseHistoryList.isEmpty()) {
//                 vbox.getChildren().add(new Label("No purchase history available for this drug."));
//             } else {
//                 for (PurchaseHistory history : purchaseHistoryList) {
//                     Label historyLabel = new Label(
//                             "Date: " + history.getPurchaseDateTime() +
//                                     ", Buyer: " + history.getBuyer() +
//                                     ", Quantity: " + history.getQuantity() +
//                                     ", Total Amount: " + history.getTotalAmount()
//                     );
//                     historyLabel.getStyleClass().add("label");
//                     vbox.getChildren().add(historyLabel);
//                 }
//             }

//             primaryStage.setScene(new Scene(vbox, 400, 350));
//         });

//         backButton.setOnAction(event -> backButtonHandler.goBack());

//         vbox.getChildren().addAll(drugCodeField, searchButton, backButton);
//         Scene scene = new Scene(vbox, 400, 350);
//         scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//         backButtonHandler.pushScene(primaryStage.getScene());
//         primaryStage.setScene(scene);
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

//FIFTH
package com.pharmacy;

import com.pharmacy.models.Drug;
import com.pharmacy.models.PurchaseHistory;
import com.pharmacy.models.Supplier;
import com.pharmacy.services.DrugService;
import com.pharmacy.services.PurchaseHistoryService;
import com.pharmacy.services.SupplierService;
import com.pharmacy.utils.BackButtonHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    private BackButtonHandler backButtonHandler;
    private Scene mainMenuScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pharmacy Management System");
        backButtonHandler = BackButtonHandler.getInstance(primaryStage);

        VBox vbox = new VBox();
        vbox.getStyleClass().add("root");

        Label titleLabel = new Label("Pharmacy Management System");
        titleLabel.getStyleClass().add("title");

        Button addDrugButton = new Button("Add Drug");
        Button viewDrugsButton = new Button("View Drugs");
        Button addSupplierButton = new Button("Add Supplier");
        Button viewSuppliersButton = new Button("View Suppliers");
        Button viewPurchaseHistoryButton = new Button("View Purchase History");

        addDrugButton.getStyleClass().add("button");
        viewDrugsButton.getStyleClass().add("button");
        addSupplierButton.getStyleClass().add("button");
        viewSuppliersButton.getStyleClass().add("button");
        viewPurchaseHistoryButton.getStyleClass().add("button");

        addDrugButton.setOnAction(event -> showAddDrugForm(primaryStage));
        viewDrugsButton.setOnAction(event -> showViewDrugs(primaryStage));
        addSupplierButton.setOnAction(event -> showAddSupplierForm(primaryStage));
        viewSuppliersButton.setOnAction(event -> showViewSuppliers(primaryStage));
        viewPurchaseHistoryButton.setOnAction(event -> showViewPurchaseHistory(primaryStage));

        vbox.getChildren().addAll(titleLabel, addDrugButton, viewDrugsButton, addSupplierButton, viewSuppliersButton, viewPurchaseHistoryButton);

        mainMenuScene = new Scene(vbox, 400, 350);
        mainMenuScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }
    
   

    private void showAddDrugForm(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.getStyleClass().add("root");

        TextField drugCodeField = new TextField();
        TextField nameField = new TextField();
        TextField descriptionField = new TextField();
        TextField quantityField = new TextField();
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        drugCodeField.setPromptText("Drug Code");
        nameField.setPromptText("Name");
        descriptionField.setPromptText("Description");
        quantityField.setPromptText("Quantity");

        drugCodeField.getStyleClass().add("text-field");
        nameField.getStyleClass().add("text-field");
        descriptionField.getStyleClass().add("text-field");
        quantityField.getStyleClass().add("text-field");

        submitButton.getStyleClass().add("button");
        backButton.getStyleClass().add("button");

        submitButton.setOnAction(event -> {
            String drugCode = drugCodeField.getText();
            String name = nameField.getText();
            String description = descriptionField.getText();
            int quantity = Integer.parseInt(quantityField.getText());

            DrugService drugService = new DrugService();
            drugService.addDrug(new Drug(drugCode, name, description, quantity));

            showSuccessMessage(primaryStage, "Drug added successfully!");
        });

        backButton.setOnAction(event -> backButtonHandler.goBack());

        vbox.getChildren().addAll(drugCodeField, nameField, descriptionField, quantityField, submitButton, backButton);
        Scene scene = new Scene(vbox, 400, 350);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        backButtonHandler.pushScene(primaryStage.getScene());
        primaryStage.setScene(scene);
    }


    private void showSuccessMessage(Stage primaryStage, String message) {
        VBox vbox = new VBox();
        vbox.getStyleClass().add("root");

        Label messageLabel = new Label(message);
        messageLabel.getStyleClass().add("label");

        Button backButton = new Button("Back");
        backButton.getStyleClass().add("button");

        backButton.setOnAction(event -> primaryStage.setScene(mainMenuScene));

        vbox.getChildren().addAll(messageLabel, backButton);
        Scene scene = new Scene(vbox, 400, 350);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
    }

   
    private void showViewDrugs(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.getStyleClass().add("root");
    
        DrugService drugService = new DrugService();
        List<Drug> drugs = drugService.getAllDrugs();
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("button");
    
        if (drugs.isEmpty()) {
            Label noDrugsLabel = new Label("No drugs available.");
            noDrugsLabel.getStyleClass().add("label");
            vbox.getChildren().add(noDrugsLabel);
        } else {
            VBox drugsContainer = new VBox(); // Container for drug boxes
            drugsContainer.getStyleClass().add("drugs-container");
    
            for (Drug drug : drugs) {
                VBox drugBox = new VBox();
                drugBox.getStyleClass().add("drug-box");
    
                Label drugNameLabel = new Label(drug.getName());
                drugNameLabel.getStyleClass().add("drug-name");
    
                Label drugCodeLabel = new Label("Code: " + drug.getDrugCode());
                drugCodeLabel.getStyleClass().add("drug-details");
    
                Label drugDescriptionLabel = new Label("Description: " + drug.getDescription());
                drugDescriptionLabel.getStyleClass().add("drug-details");
    
                drugBox.getChildren().addAll(drugNameLabel, drugCodeLabel, drugDescriptionLabel);
                drugsContainer.getChildren().add(drugBox);
            }
    
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(drugsContainer);
            scrollPane.setFitToWidth(true); // Expand scroll pane to fit width of scene
            scrollPane.getStyleClass().add("scroll-pane");
    
            vbox.getChildren().add(scrollPane);
        }
    
        backButton.setOnAction(event -> backButtonHandler.goBack());
        vbox.getChildren().add(backButton);
    
        Scene scene = new Scene(vbox, 400, 350);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        backButtonHandler.pushScene(primaryStage.getScene());
        primaryStage.setScene(scene);
    }
    
    

    private void showAddSupplierForm(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.getStyleClass().add("root");

        TextField nameField = new TextField();
        TextField locationField = new TextField();
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");

        nameField.setPromptText("Name");
        locationField.setPromptText("Location");

        nameField.getStyleClass().add("text-field");
        locationField.getStyleClass().add("text-field");

        submitButton.getStyleClass().add("button");
        backButton.getStyleClass().add("button");

        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String location = locationField.getText();

            SupplierService supplierService = new SupplierService();
            supplierService.addSupplier(new Supplier(name, location));

            showSuccessMessage(primaryStage, "Supplier added successfully!");
        });

        backButton.setOnAction(event -> backButtonHandler.goBack());

        vbox.getChildren().addAll(nameField, locationField, submitButton, backButton);
        Scene scene = new Scene(vbox, 400, 350);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        backButtonHandler.pushScene(primaryStage.getScene());
        primaryStage.setScene(scene);
    }

    
    private void showViewSuppliers(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.getStyleClass().add("root");
    
        SupplierService supplierService = new SupplierService();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("button");
    
        if (suppliers.isEmpty()) {
            Label noSuppliersLabel = new Label("No suppliers available.");
            noSuppliersLabel.getStyleClass().add("label");
            vbox.getChildren().add(noSuppliersLabel);
        } else {
            VBox suppliersContainer = new VBox(); // Container for supplier boxes
            suppliersContainer.getStyleClass().add("suppliers-container");
    
            for (Supplier supplier : suppliers) {
                VBox supplierBox = new VBox();
                supplierBox.getStyleClass().add("box");
    
                Label supplierNameLabel = new Label(supplier.getName());
                supplierNameLabel.getStyleClass().add("box-title");
    
                Label supplierLocationLabel = new Label("Location: " + supplier.getLocation());
                supplierLocationLabel.getStyleClass().add("box-subtitle");
    
                supplierBox.getChildren().addAll(supplierNameLabel, supplierLocationLabel);
                suppliersContainer.getChildren().add(supplierBox);
            }
    
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(suppliersContainer);
            scrollPane.setFitToWidth(true); // Expand scroll pane to fit width of scene
            scrollPane.getStyleClass().add("scroll-pane");
    
            vbox.getChildren().add(scrollPane);
        }
    
        backButton.setOnAction(event -> backButtonHandler.goBack());
        vbox.getChildren().add(backButton);
    
        Scene scene = new Scene(vbox, 400, 350);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        backButtonHandler.pushScene(primaryStage.getScene());
        primaryStage.setScene(scene);
    }
    

    private void showViewPurchaseHistory(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.getStyleClass().add("root");

        TextField drugCodeField = new TextField();
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");

        drugCodeField.setPromptText("Drug Code");

        drugCodeField.getStyleClass().add("text-field");
        searchButton.getStyleClass().add("button");
        backButton.getStyleClass().add("button");

        searchButton.setOnAction(event -> {
            String drugCode = drugCodeField.getText();
            PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
            List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.getPurchaseHistory(drugCode);

            if (purchaseHistoryList.isEmpty()) {
                Label noHistoryLabel = new Label("No purchase history available for this drug.");
                noHistoryLabel.getStyleClass().add("label");
                vbox.getChildren().add(noHistoryLabel);
            } else {
                for (PurchaseHistory history : purchaseHistoryList) {
                    VBox historyBox = new VBox();
                    historyBox.getStyleClass().add("box");

                    Label historyDateLabel = new Label("Date: " + history.getPurchaseDateTime());
                    historyDateLabel.getStyleClass().add("box-subtitle");
                    
                    Label historyBuyerLabel = new Label("Buyer: " + history.getBuyer());
                    historyBuyerLabel.getStyleClass().add("box-subtitle");
                    
                    Label historyQuantityLabel = new Label("Quantity: " + history.getQuantity());
                    historyQuantityLabel.getStyleClass().add("box-subtitle");
                    
                    Label historyAmountLabel = new Label("Total Amount: " + history.getTotalAmount());
                    historyAmountLabel.getStyleClass().add("box-subtitle");

                    historyBox.getChildren().addAll(historyDateLabel, historyBuyerLabel, historyQuantityLabel, historyAmountLabel);
                    vbox.getChildren().add(historyBox);
                }
            }

            Scene newScene = new Scene(vbox, 400, 350);
            newScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
            primaryStage.setScene(newScene);
        });

        backButton.setOnAction(event -> backButtonHandler.goBack());

        vbox.getChildren().addAll(drugCodeField, searchButton, backButton);
        Scene scene = new Scene(vbox, 400, 350);
        scene.getStylesheets().add (getClass().getResource("/styles.css").toExternalForm());
        backButtonHandler.pushScene(primaryStage.getScene());
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}






