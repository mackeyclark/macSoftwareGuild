/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.service;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author macam
 */
public class VmServiceTest {
    
    private VmService service;
    
    public VmServiceTest() {
//        VmDao dao = new VmDaoStubImpl();
//        
//        service = new VmServiceImpl(dao);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("VmServiceLayer", VmServiceImpl.class);
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
    public void testVend() throws Exception {
        //???
    }

    /**
     * Test of getProducts method, of class VmService.
     */
    @Test
    public void testGetProducts() throws Exception {
        assertEquals(1, service.getProducts().size());
    }
    
}
