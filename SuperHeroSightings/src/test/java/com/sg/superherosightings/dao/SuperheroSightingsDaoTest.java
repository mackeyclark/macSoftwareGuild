/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Superhuman;
import java.util.ArrayList;
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

    JdbcTemplate jdbc;
    
    SuperheroSightingsJdbcDaoImpl dao;

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

        dao = new SuperheroSightingsJdbcDaoImpl();
        dao.setJdbcTemplate(jdbc);

    }

    @After
    public void tearDown() {
        
        dao.clearAllData();
        
    }

    /**
     * Test of getSuperhumanWithId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddGetSuperhuman() {
        Power power = new Power();
        power.setName("One-for-All");
        power.setDescription("A Quirk that stockpiles power");

        dao.addPower(power);

        List<Integer> powerList = new ArrayList<>();
        powerList.add(power.getPowerId());

        Organization organization = new Organization();
        organization.setName("U.A. High School");
        organization.setDescription("academy where students learn and train to become heroes");
        organization.setAddress("31 Tenzu Street Musutafu, Japan");
        organization.setPhone("1234567890");
        organization.setEmail("plusUltra@Comcast.net");

        dao.addOrganization(organization);

        List<Integer> organizationList = new ArrayList<>();
        organizationList.add(organization.getOrganizationId());

        Superhuman superhuman = new Superhuman();
        superhuman.setName("All Might");
        superhuman.setDescription("#1 Hero");
        superhuman.setPowers(powerList);
        superhuman.setOrganizations(organizationList);

        dao.addSuperhuman(superhuman);

        Superhuman fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(fromDao, superhuman);
    }

    /**
     * Test of deleteSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testDeleteSuperhuman() {
        Power power = new Power();
        power.setName("One-for-All");
        power.setDescription("A Quirk that stockpiles power");

        dao.addPower(power);

        List<Integer> powerList = new ArrayList<>();
        powerList.add(power.getPowerId());

        Organization organization = new Organization();
        organization.setName("U.A. High School");
        organization.setDescription("academy where students learn and train to become heroes");
        organization.setAddress("31 Tenzu Street Musutafu, Japan");
        organization.setPhone("1234567890");
        organization.setEmail("plusUltra@Comcast.net");

        dao.addOrganization(organization);

        List<Integer> organizationList = new ArrayList<>();
        organizationList.add(organization.getOrganizationId());

        Superhuman superhuman = new Superhuman();
        superhuman.setName("All Might");
        superhuman.setDescription("#1 Hero");
        superhuman.setPowers(powerList);
        superhuman.setOrganizations(organizationList);

        dao.addSuperhuman(superhuman);

        Superhuman fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(fromDao, superhuman);

        dao.deleteSuperhuman(superhuman.getHeroId());
        fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertNull(fromDao);
    }

    /**
     * Test of updateSuperhuman method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateSuperhuman() {
        Power power = new Power();
        power.setName("One-for-All");
        power.setDescription("A Quirk that stockpiles power");

        dao.addPower(power);

        List<Integer> powerList = new ArrayList<>();
        powerList.add(power.getPowerId());

        Organization organization = new Organization();
        organization.setName("U.A. High School");
        organization.setDescription("academy where students learn and train to become heroes");
        organization.setAddress("31 Tenzu Street Musutafu, Japan");
        organization.setPhone("1234567890");
        organization.setEmail("plusUltra@Comcast.net");

        dao.addOrganization(organization);

        List<Integer> organizationList = new ArrayList<>();
        organizationList.add(organization.getOrganizationId());

        Superhuman superhuman = new Superhuman();
        superhuman.setName("All Might");
        superhuman.setDescription("#1 Hero");
        superhuman.setPowers(powerList);
        superhuman.setOrganizations(organizationList);

        dao.addSuperhuman(superhuman);

        Superhuman fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(fromDao, superhuman);

        Power powerTwo = new Power();
        powerTwo.setName("All-for-One");
        powerTwo.setDescription("A quirk that traanfers other's quirks");

        dao.addPower(powerTwo);
        powerList.add(powerTwo.getPowerId());

        Organization organizationTwo = new Organization();
        organizationTwo.setName("League of Villains");
        organizationTwo.setDescription("group of villans inspired by Stain's philosiphy");
        organizationTwo.setAddress("Somewhere in Kamino Ward");
        organizationTwo.setPhone("2345678901");
        organizationTwo.setEmail("freeStain@jol.com");

        dao.addOrganization(organizationTwo);
        organizationList.add(organizationTwo.getOrganizationId());

        superhuman.setName("All-for-One");
        superhuman.setDescription("Leader of the League of Villans");
        superhuman.setPowers(powerList);
        superhuman.setOrganizations(organizationList);
        dao.updateSuperhuman(superhuman);

        Superhuman updatedFromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(updatedFromDao, superhuman);
    }

    /**
     * Test of getAllSuperhumans method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSuperhumans() {
        Power power = new Power();
        power.setName("One-for-All");
        power.setDescription("A Quirk that stockpiles power");

        dao.addPower(power);

        List<Integer> powerList = new ArrayList<>();
        powerList.add(power.getPowerId());

        Organization organization = new Organization();
        organization.setName("U.A. High School");
        organization.setDescription("academy where students learn and train to become heroes");
        organization.setAddress("31 Tenzu Street Musutafu, Japan");
        organization.setPhone("1234567890");
        organization.setEmail("plusUltra@Comcast.net");

        dao.addOrganization(organization);

        List<Integer> organizationList = new ArrayList<>();
        organizationList.add(organization.getOrganizationId());

        Superhuman superhuman = new Superhuman();
        superhuman.setName("All Might");
        superhuman.setDescription("#1 Hero");
        superhuman.setPowers(powerList);
        superhuman.setOrganizations(organizationList);

        dao.addSuperhuman(superhuman);

        Superhuman fromDao = dao.getSuperhumanWithId(superhuman.getHeroId());
        assertEquals(fromDao, superhuman);

        Power powerTwo = new Power();
        powerTwo.setName("All-for-One");
        powerTwo.setDescription("A quirk that traanfers other's quirks");

        dao.addPower(powerTwo);

        List<Integer> powerTwoList = new ArrayList<>();
        powerTwoList.add(powerTwo.getPowerId());

        Organization organizationTwo = new Organization();
        organizationTwo.setName("League of Villains");
        organizationTwo.setDescription("group of villans inspired by Stain's philosiphy");
        organizationTwo.setAddress("Somewhere in Kamino Ward");
        organizationTwo.setPhone("2345678901");
        organizationTwo.setEmail("freeStain@jol.com");

        dao.addOrganization(organizationTwo);

        List<Integer> organizationTwoList = new ArrayList<>();
        organizationTwoList.add(organizationTwo.getOrganizationId());

        Superhuman superhumanTwo = new Superhuman();
        superhumanTwo.setName("All-for-One");
        superhumanTwo.setDescription("Leader of the League of Villans");
        superhumanTwo.setPowers(powerTwoList);
        superhumanTwo.setOrganizations(organizationTwoList);
        dao.addSuperhuman(superhumanTwo);
        
        assertEquals(dao.getAllSuperhumans().size(), 2);
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
