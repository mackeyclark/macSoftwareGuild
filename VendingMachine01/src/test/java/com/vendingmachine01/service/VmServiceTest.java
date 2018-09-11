/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.service;

import com.vendingmachine01.dao.VmAuditDao;
import com.vendingmachine01.dao.VmAuditDaoStubImpl;
import com.vendingmachine01.dao.VmDao;
import com.vendingmachine01.dao.VmDaoStubImpl;
import com.vendingmachine01.dao.VmPersistenceException;
import com.vendingmachine01.dto.Item;
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
public class VmServiceTest {
    
    private VmService service;
    
    public VmServiceTest() {
        VmDao dao = new VmDaoStubImpl();
        VmAuditDao auditDao = new VmAuditDaoStubImpl();
        
        service = new VmServiceImpl(dao, auditDao);

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of vend method, of class VmService.
     */
    @Test
    public void testVend()  {
        Item onlyItem = new Item("Candy", 500, 999);
        
    }
    
    @Test
    public void testVendInsufficentFunds() throws Exception {
        
    }
    
    @Test
    public void testVendNoItem() throws Exception {
        
    }
    
    /**
     * Test of getProducts method, of class VmService.
     */
    @Test
    public void testGetProducts() {
        try {
            assertEquals(1, service.getProducts().size());
        } catch (VmPersistenceException ex) {
            
        }
    }
    
}
