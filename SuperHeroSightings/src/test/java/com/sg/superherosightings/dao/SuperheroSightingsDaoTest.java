/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.Superhuman;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author macam
 */
public class SuperheroSightingsDaoTest {

    SuperheroSightingsDaoJdbcTemplateImpl dao;

    public SuperheroSightingsDaoTest() {
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
        JdbcTemplate jdbc = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        dao = new SuperheroSightingsDaoJdbcTemplateImpl();
        dao.setJdbcTemplate(jdbc);

        //get and delete all superhumans
        List<Superhuman> superhumans = dao.getAllSuperhumans();
        for (Superhuman currentSuperhuman : superhumans) {
            dao.deleteSuperhuman(currentSuperhuman.getHeroId());
        }

        //get and delete all powers
        List<Power> powers = dao.getAllPowers();
        for (Power currentPower : powers) {
            dao.deletePower(currentPower.getPowerId());
        }

        //get and delete all organizations
        List<Organization> organizations = dao.getAllOrganizations();
        for (Organization currentOrganization : organizations) {
            dao.deleteOrganization(currentOrganization.getOrganizationId());
        }

        //get and delete all locations
        List<Location> locations = dao.getAllLocations();
        for (Location currentLocation : locations) {
            dao.deleteLocation(currentLocation.getLocationId());
        }

        //get and delete all sightings
        List<Sighting> sightings = dao.getAllSightings();
        for (Sighting currentSighting : sightings) {
            dao.deleteSighting(currentSighting.getSightingId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSuperhumanWithId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddGetSuperhuman() {
        Superhuman superhuman = new Superhuman();
        superhuman.setName("All Might");
        superhuman.setDescription("#1 Hero");

        dao.addSuperhuman(superhuman);

        Superhuman fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(fromDao, superhuman);

    }

    /**
     * Test of deleteSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testDeleteSuperhuman() {
        Superhuman superhuman = new Superhuman();
        superhuman.setName("All Might");
        superhuman.setDescription("#1 Hero");

        dao.addSuperhuman(superhuman);

        Superhuman fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(fromDao, superhuman);
        dao.deleteSuperhuman(superhuman.getHeroId());
        assertNull(dao.getSuperhumanWithId(superhuman.getHeroId()));
    }

    /**
     * Test of updateSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateSuperhuman() {
        Superhuman superhuman = new Superhuman();
        superhuman.setName("All Might");
        superhuman.setDescription("#1 Hero");

        dao.addSuperhuman(superhuman);

        Superhuman fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(fromDao, superhuman);

        superhuman.setName("Endeavor");

        dao.updateSuperhuman(superhuman);

        Superhuman newFromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(newFromDao, superhuman);

    }

    /**
     * Test of getAllSuperhumans method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSuperhumans() {
        Superhuman proHero = new Superhuman();
        proHero.setName("All Might");
        proHero.setDescription("#1 Hero");
        
        dao.addSuperhuman(proHero);
        
        Superhuman uaStudent = new Superhuman();
        uaStudent.setName("Deku");
        uaStudent.setDescription("Training to become the #1 Hero");
        
        dao.addSuperhuman(uaStudent);
        
        List<Superhuman> getList = dao.getAllSuperhumans();
        assertEquals(getList.size(), 2);
    }

    /**
     * Test of getAllSuperhumansInOrganization method, of class
     * SuperheroSightingsDao.
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
     * Test of getOrganizationsOfSuperhuman method, of class
     * SuperheroSightingsDao.
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
