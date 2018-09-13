/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.TaxRate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author macam
 */
public class FmTaxesDaoTest {
    
    FmTaxesDao Tdao = new FmTaxesDaoFileImpl();
    
    public FmTaxesDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        Files.copy(Paths.get("TaxesTest.txt"), Paths.get("Taxes.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllStateTaxRates method, of class FmTaxesDao.
     */
    @Test
    public void testGetAllStateTaxRates() throws FmPersistenceException {
        List<TaxRate> taxList = Tdao.getAllStateTaxRates();
        
        Stream<TaxRate> step1 = taxList.stream();
        Stream<TaxRate> step2 = step1.filter(t -> t.getState().equals("OH"));
        List<TaxRate> step3 = step2.collect(Collectors.toList());
        TaxRate testTax = step3.get(0);
        
        assertEquals(new BigDecimal(6.25).setScale(2, RoundingMode.HALF_UP), testTax.getTaxRate());
    }
}
