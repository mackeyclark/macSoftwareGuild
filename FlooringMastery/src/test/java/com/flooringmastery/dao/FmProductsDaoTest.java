/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Product;
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
public class FmProductsDaoTest {
    
    FmProductsDao Pdao = new FmProductsDaoFileImpl();
    
    public FmProductsDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        Files.copy(Paths.get("ProductsTest.txt"), Paths.get("Products.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllMaterialCosts method, of class FmProductsDao.
     */
    @Test
    public void testGetAllMaterialCosts() throws Exception {
        List<Product> prodList = Pdao.getAllMaterialCosts();
        
        Stream<Product> step1 = prodList.stream();
        Stream<Product> step2 = step1.filter(s -> s.getProduct().equals("Wood"));
        List<Product> step3 = step2.collect(Collectors.toList());
        Product testProd = step3.get(0);
        
        assertEquals(new BigDecimal(5.15).setScale(2, RoundingMode.HALF_UP), testProd.getCostSqFt());
        assertEquals(new BigDecimal(4.75).setScale(2, RoundingMode.HALF_UP), testProd.getLaborCostSqFt());
    }
}
