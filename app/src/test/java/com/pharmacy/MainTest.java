package com.pharmacy;

import com.pharmacy.models.*;
import com.pharmacy.services.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.checkerframework.checker.units.qual.s;

class MainTest {
    @Test
    void testAddDrug() {
        DrugService drugService = new DrugService();
        Drug drug = new Drug("D001", "Aspirin", "Pain reliever", 100, 56.7f);
        drugService.addDrug(drug);
        
        Drug retrievedDrug = drugService.searchDrug("D001");
        assertEquals(drug.getName(), retrievedDrug.getName());
    }

    @Test
    void testSearchDrug() {
        DrugService drugService = new DrugService();
        Drug drug = new Drug("D002", "Paracetamol", "Fever reducer", 200, 56.7f);
        drugService.addDrug(drug);

        Drug retrievedDrug = drugService.searchDrug("D002");
        assertEquals(drug.getName(), retrievedDrug.getName());
    }

    @Test
    void testAddSupplier() {
        // Given
        String expectedName = "Supplier A";
        String expectedLocation = "Accra";

        SupplierService supplierService = new SupplierService();
        Supplier supplier = new Supplier(expectedName, expectedLocation);

        supplierService.addSupplier(supplier);

        assertEquals(expectedName, supplier.getName());
        assertEquals(expectedLocation, supplier.getLocation());
       
    }

    @Test
    void testAddCustomer(){
        String name = "Godfred";
        String contact = "02444444444 ";
        String address = "University of Ghana";

        CustomerService customerService = new CustomerService();
        Customer customer = new Customer(name, contact, address);

        customerService.addCustomer(customer);
        assertEquals(name,customer.getName());
        assertEquals(contact, customer.getContact());
        assertEquals(address, customer.getAddress());
    }

    // Additional test cases
}
