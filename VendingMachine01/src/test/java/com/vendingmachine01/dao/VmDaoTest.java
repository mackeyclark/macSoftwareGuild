/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.dao;

import com.vendingmachine01.dto.Item;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
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
public class VmDaoTest {
    
    private VmDao dao = new VmDaoFileImpl();
    
    public VmDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        //copy seed file over top of writing file
        Files.copy(Paths.get("vmTest.txt"), Paths.get("vm.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProducts method, of class VmDao.
     */
    @Test
    public void testGetProducts() throws Exception {
        List<Item> products = dao.getProducts();
        
        Item singleItem = products.stream()
                .filter(p -> p.getName().equals("Chocolate Bar"))
                .collect(Collectors.toList())
                .get(0);
        
        assertEquals(67, singleItem.getPricePennies());
        assertEquals(3, singleItem.getInventory());
        
        Item anotherItem = products.stream()
                .filter(p -> p.getName().equals("Potato Crisps"))
                .collect(Collectors.toList())
                .get(0);
        
        assertEquals(99, anotherItem.getPricePennies());
        assertEquals(0, anotherItem.getInventory());
        
        Item lastItem = products.stream()
                .filter(p -> p.getName().equals("Bag o' Jerky"))
                .collect(Collectors.toList())
                .get(0);
        
        assertEquals(120, lastItem.getPricePennies());
        assertEquals(1, lastItem.getInventory());
    }

    /**
     * Test of saveItem method, of class VmDao.
     */
    @Test
    public void testSaveItem() throws Exception {
        List<Item> products = dao.getProducts();
        
        Item singleItem = products.stream()
                .filter(p -> p.getName().equals("Chocolate Bar"))
                .collect(Collectors.toList())
                .get(0);
        
        assertEquals(3, singleItem.getInventory());
        
        singleItem.setInventory(2);
        
        dao.saveItem(singleItem);
        
        
        Item validationItem = dao.getProducts().stream()
                .filter(p -> p.getName().equals("Chocolate Bar"))
                .collect(Collectors.toList())
                .get(0);
        
        assertEquals(2, validationItem.getInventory());
    }

}
