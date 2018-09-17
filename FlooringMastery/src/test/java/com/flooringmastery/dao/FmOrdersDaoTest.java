/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Order;
import java.math.BigDecimal;
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
    
    @Test
    public void testCreateOrder() throws Exception {
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        
        Order order = new Order();
        order.setDate(ld);
        order.setCustomerName("Ganon");
        order.setState("OH");
        order.setTaxRate(BigDecimal.valueOf(6.25));
        order.setProductType("Tile");
        order.setArea(BigDecimal.valueOf(333));
        order.setCostSqFt(BigDecimal.valueOf(3.50));
        order.setCostLaborSqFt(BigDecimal.valueOf(4.15));
        
        dao.createOrder(order);
        //get the orders of a file
        //assert that there are two objects in the returned list
        List<Order> ol = dao.getOrdersByDate(order.getDate());
        
        assertEquals(2, ol.stream().count());
        
    }
    
    @Test
    public void testGetAndRemoveOrder() throws Exception {
        String dateToLookFor = "06012013";
        LocalDate ld = LocalDate.parse(dateToLookFor, DateTimeFormatter.ofPattern("MMddyyyy"));
        
        List<Order> orderList = dao.getOrdersByDate(ld);
        
        Order order = dao.getOrder(orderList, 1);
        
        assertNotNull(order);
        
        dao.removeOrder(order);
        
        orderList = dao.getOrdersByDate(ld);
        
        assertEquals(0, orderList.size());
    }
    
    @Test
    public void testEditOrder() throws Exception {
        //get an order
        //edit that order's name
        //assert that order's name equals new name
        //assert that the order number is the same
        String dateToLookFor = "06012013";
        LocalDate ld = LocalDate.parse(dateToLookFor, DateTimeFormatter.ofPattern("MMddyyyy"));
        
        List<Order> orderList = dao.getOrdersByDate(ld);
        
        Order order = dao.getOrder(orderList, 1);
        
        assertNotNull(order);
        
        
    }
}
