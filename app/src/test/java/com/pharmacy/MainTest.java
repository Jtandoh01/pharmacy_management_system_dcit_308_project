package com.pharmacy;

import com.pharmacy.models.Drug;
import com.pharmacy.services.DrugService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testAddDrug() {
        DrugService drugService = new DrugService();
        Drug drug = new Drug("D001", "Aspirin", "Pain reliever", 100);
        drugService.addDrug(drug);
        
        Drug retrievedDrug = drugService.searchDrug("D001");
        assertEquals(drug.getName(), retrievedDrug.getName());
    }

    @Test
    void testSearchDrug() {
        DrugService drugService = new DrugService();
        Drug drug = new Drug("D002", "Paracetamol", "Fever reducer", 200);
        drugService.addDrug(drug);

        Drug retrievedDrug = drugService.searchDrug("D002");
        assertEquals(drug.getName(), retrievedDrug.getName());
    }

    // Additional test cases
}
