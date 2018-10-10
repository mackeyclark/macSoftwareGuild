/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.dao;

import com.sg.contactlistspringmvc.model.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author macam
 */
public class ContactListDaoTest {

    private ContactListDao dao;

    public ContactListDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("ContactListDao", ContactListDao.class);
        
        List<Contact> contacts = dao.getAllContacts();
        for (Contact currentContact : contacts) {
            dao.removeContact(currentContact.getContactId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addContact method, of class ContactListDao.
     */
    @Test
    public void addGetDeleteContact() {
        //create new contact
        Contact nc = new Contact();
        nc.setFirstName("Doc");
        nc.setLastName("Holiday");
        nc.setCompany("Tombstone llc");
        nc.setPhone("555-5555");
        nc.setEmail("dh@tllc.com");
        dao.addContact(nc);
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb, nc);
        dao.removeContact(nc.getContactId());
        assertNull(dao.getContactById(nc.getContactId()));
    }

    /**
     * Test of updateContact method, of class ContactListDao.
     */
    @Test
    public void addUpdateContact() {
        //create new contact
        Contact nc = new Contact();
        nc.setFirstName("Wyatt");
        nc.setLastName("Earp");
        nc.setCompany("Outlaw");
        nc.setEmail("we@outlaw.net");
        nc.setPhone("123-9876");
        dao.addContact(nc);
        nc.setPhone("234-8765");
        dao.updateContact(nc);
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb, nc);
    }

    /**
     * Test of getAllContacts method, of class ContactListDao.
     */
    @Test
    public void getAllContacts() {
        //create new contact
        Contact nc = new Contact();
        nc.setFirstName("Doc");
        nc.setLastName("Holiday");
        nc.setCompany("Tombstone llc");
        nc.setPhone("555-5555");
        nc.setEmail("dh@tllc.com");
        dao.addContact(nc);
        //create new contact
        Contact nc2 = new Contact();
        nc2.setFirstName("Wyatt");
        nc2.setLastName("Earp");
        nc2.setCompany("Outlaw");
        nc2.setEmail("we@outlaw.net");
        nc2.setPhone("123-9876");
        dao.addContact(nc2);
        List<Contact> cList = dao.getAllContacts();
        assertEquals(cList.size(), 2);
    }

    /**
     * Test of searchContacts method, of class ContactListDao.
     */
    @Test
    public void searchContacts() {
        //create new contact
        Contact nc = new Contact();
        nc.setFirstName("Wyatt");
        nc.setLastName("Earp");
        nc.setCompany("Outlaw");
        nc.setEmail("we@outlaw.net");
        nc.setPhone("123-9876");
        dao.addContact(nc);
        //create new contact
        Contact nc2 = new Contact();
        nc2.setFirstName("Doc");
        nc2.setLastName("Holiday");
        nc2.setCompany("Tombstone llc");
        nc2.setPhone("555-5555");
        nc2.setEmail("dh@tllc.com");
        dao.addContact(nc2);
        //create contact - same last name as first but different company
        Contact nc3 = new Contact();
        nc3.setFirstName("Morgan");
        nc3.setLastName("Earp");
        nc3.setCompany("Gunslingers");
        nc3.setEmail("me@gunslingers.com");
        nc3.setPhone("111-1121");
        dao.addContact(nc3);
        //create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.LAST_NAME, "Holiday");
        List<Contact> cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0));

        //new search criteria - look for Earp
        criteria.put(SearchTerm.LAST_NAME, "Earp");
        cList = dao.searchContacts(criteria);
        assertEquals(2, cList.size());

        //add company to search criteria
        criteria.put(SearchTerm.COMPANY, "Outlaw");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc, cList.get(0));

        //change company to Gunslingers should get back nc3
        criteria.put(SearchTerm.COMPANY, "Gunslingers");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc3, cList.get(0));
        //change compant to tombstone llc should get back nothing
        criteria.put(SearchTerm.COMPANY, "Tombstone llc");
        cList = dao.searchContacts(criteria);
        assertEquals(0, cList.size());
    }

}
