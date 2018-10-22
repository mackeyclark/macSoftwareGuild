/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Superhuman;
import java.util.List;
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
public class SuperheroSightingsDaoTest {
    
    SuperheroSightingsDao dao;
    
    public SuperheroSightingsDaoTest(SuperheroSightingsDao dao) {
        this.dao = dao;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationcontext.xml");
        
        dao = ctx.getBean("superheroSightingsDao", SuperheroSightingsDao.class);
        
        //get all the things!
        List<Superhuman> superhumans = dao.getAllSuperhumans();
//        List<Organization> organizations = dao.getAllOrganizations();
//        List<Power> powers = dao.getAllPowers();
//        List<Location> locations = dao.getAllLocations();
//        List<Sighting> sightings = dao.getAllSightings();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deleteSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testDeleteSuperhuman() {
    }

    /**
     * Test of updateSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateSuperhuman() {
    }

    /**
     * Test of getSuperhumanWithId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddGetSuperhumanWithId() {
        
    }

    /**
     * Test of getAllSuperhumans method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSuperhumans() {
    }

    /**
     * Test of getAllSuperhumansInOrganization method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSuperhumansInOrganization() {
    }

    /**
     * Test of addSighting method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddSighting() {
    }

    /**
     * Test of deleteSighting method, of class SuperheroSightingsDao.
     */
    @Test
    public void testDeleteSighting() {
    }

    /**
     * Test of updateSighting method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateSighting() {
    }

    /**
     * Test of getSightingWithId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetSightingWithId() {
    }

    /**
     * Test of getAllSightings method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSightings() {
    }

    /**
     * Test of getAllSightingsOfLocation method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSightingsOfLocation() {
    }

    /**
     * Test of getAllSightingsOnDate method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSightingsOnDate() {
    }

    /**
     * Test of addPower method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddPower() {
    }

    /**
     * Test of deletePower method, of class SuperheroSightingsDao.
     */
    @Test
    public void testDeletePower() {
    }

    /**
     * Test of updatePower method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdatePower() {
    }

    /**
     * Test of getPowerWithId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetPowerWithId() {
    }

    /**
     * Test of getAllPowers method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllPowers() {
    }

    /**
     * Test of addOrganization method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddOrganization() {
    }

    /**
     * Test of deleteOrganization method, of class SuperheroSightingsDao.
     */
    @Test
    public void testDeleteOrganization() {
    }

    /**
     * Test of updateOrganization method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateOrganization() {
    }

    /**
     * Test of getOrganizationWithId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetOrganizationWithId() {
    }

    /**
     * Test of getAllOrganizations method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllOrganizations() {
    }

    /**
     * Test of getOrganizationsOfSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetOrganizationsOfSuperhuman() {
    }

    /**
     * Test of addLocation method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddLocation() {
    }

    /**
     * Test of deleteLocation method, of class SuperheroSightingsDao.
     */
    @Test
    public void testDeleteLocation() {
    }

    /**
     * Test of updateLocation method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateLocation() {
    }

    /**
     * Test of getLocationWithId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetLocationWithId() {
    }

    /**
     * Test of getAllLocations method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllLocations() {
    }

    /**
     * Test of getLocationsOfSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetLocationsOfSuperhuman() {
    }
    
}