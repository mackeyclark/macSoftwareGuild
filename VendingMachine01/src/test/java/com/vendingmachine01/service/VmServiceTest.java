/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.service;

import com.vendingmachine01.dao.VmAuditDao;
import com.vendingmachine01.dao.VmAuditDaoStubImpl;
import com.vendingmachine01.dao.VmDaoStubImpl;
import com.vendingmachine01.dao.VmPersistenceException;
import com.vendingmachine01.dto.Item;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.vendingmachine01.dao.VmDao;
import com.vendingmachine01.dto.Change;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.fail;

/**
 *
 * @author macam
 */
public class VmServiceTest {

    private VmService service;

    public VmServiceTest() {
        VmDao dao = new VmDaoStubImpl();
        VmAuditDao auditDao = new VmAuditDaoStubImpl();

        service = new VmServiceImpl(dao);

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
    public void testVend() throws VmPersistenceException {
        //1. Everything worked.
        //      Test that we got the correct change back.
        //      fail() if we hit any exceptions
        //2. No inventory
        //      fail() if we DON'T hit an exception OR if we get a different exception
        //3. Not enough money
        //      fail() if we DON'T hit an exception OR if we get a different exception

        Item testItem = null;
        int money = -1;
        try {
            testItem = service.getProducts().get(0);
            money = 241;
            Change returnedChange = service.vend(money, testItem);
            assertEquals(1, returnedChange.getDollars());
            assertEquals(1, returnedChange.getQuarters());
            assertEquals(1, returnedChange.getDimes());
            assertEquals(1, returnedChange.getNickles());
            assertEquals(1, returnedChange.getPennies());
            return;

        } catch (InsufficentFundsException ex) {
            fail("Test not expected to fail");

        } catch (NoItemInventoryException ex) {
            fail("Test not expected to fail");
        }
        
        try{
            testItem = service.getProducts().get(0);
            money = 99;
            Change returnedChange = service.vend(money, testItem);
            fail("InsufficentFundsException was not thrown");
            
        }catch (InsufficentFundsException ex) {
            return;

        } catch (NoItemInventoryException ex) {
            fail("InsufficentFundsException was not thrown");
        }
        
        try{
            money = 100;
            Change returnedChange = service.vend(money, testItem);
            fail("NoItemInventoryException was not thrown");

        } catch (InsufficentFundsException ex) {
            fail("NoItemInventoryException was not thrown");

        } catch (NoItemInventoryException ex) {
            return;
        }
    }

    /**
     * Test of getProducts method, of class VmService.
     */
    @Test
    public void testGetProducts() {
        try {
            assertEquals(1, service.getProducts().size());
        } catch (VmPersistenceException ex) {
            fail("Test not expected to fail");

        }
    }

}
