-- Create the Drugs table
CREATE TABLE Drugs (
    drugCode VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    quantity INT
);

-- Create the Suppliers table
CREATE TABLE Suppliers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

-- Create the DrugSuppliers table to manage the many-to-many relationship
CREATE TABLE DrugSuppliers (
    drugCode VARCHAR(255),
    supplierId INT,
    PRIMARY KEY (drugCode, supplierId),
    FOREIGN KEY (drugCode) REFERENCES Drugs (drugCode) ON DELETE CASCADE,
    FOREIGN KEY (supplierId) REFERENCES Suppliers (id) ON DELETE CASCADE
);

-- Create the Customer table
CREATE TABLE Customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contactNumber VARCHAR(20),
    address VARCHAR(255) NOT NULL
);

-- Update the PurchaseHistory table to include customer information
CREATE TABLE PurchaseHistory (
    id SERIAL PRIMARY KEY,
    drugCode VARCHAR(255),
    purchaseDateTime TIMESTAMP NOT NULL,
    buyer VARCHAR(255) NOT NULL,
    customerId INT,
    quantity INT NOT NULL,
    totalAmount DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (drugCode) REFERENCES Drugs (drugCode) ON DELETE CASCADE,
    FOREIGN KEY (customerId) REFERENCES Customers (id) ON DELETE SET NULL
);

-- Create the Sales table
CREATE TABLE Sales (
    id SERIAL PRIMARY KEY,
    drugCode VARCHAR(50),
    saleDateTime TIMESTAMP,
    quantity INT,
    FOREIGN KEY (drugCode) REFERENCES Drugs(drugCode)
);
