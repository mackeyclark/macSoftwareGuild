/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Order;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author macam
 */
public class FmOrdersDaoTest {
    
    private FmOrdersDao dao = new FmOrdersDaoFileImpl();
    
    public FmOrdersDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        Files.copy(Paths.get("Orders_06012013Test.txt"), Paths.get("Orders_06012013.txt"), StandardCopyOption.REPLACE_EXISTING);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOrdersByDate method, of class FmOrdersDao.
     */
    @Test
    public void testGetOrdersByDate() throws Exception {
        String dateToLookFor = "06012013";
        LocalDate ld = LocalDate.parse(dateToLookFor, DateTimeFormatter.ofPattern("MMddyyyy"));
        
        assertNotNull(dao.getOrdersByDate(ld));
    }
    
}
