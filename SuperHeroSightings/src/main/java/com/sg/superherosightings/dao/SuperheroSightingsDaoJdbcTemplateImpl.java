/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author macam
 */
public class SuperheroSightingsDaoJdbcTemplateImpl implements SuperheroSightingsDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final String SQL_INSERT_SUPERHUMAN
            = "insert into superhumans(name, description) "
            + "values (?, ?)";
    
    private static final String SQL_DELETE_SUPERHUMAN
            = "delete from superhumans where heroId = ?";
    
    private static final String SQL_UPDATE_SUPERHUMAN
            = "update superhumans set name = ?, description = ? "
            + "where heroId = ?";
    
    private static final String SQL_SELECT_SUPERHUMAN
            = "select * from superhumans where heroId = ?";
    
    private static final String SQL_SELECT_SUPERHUMANS_BY_LOCATION_ID
            = "select sh.heroId, sh.name, sh.description "
            + "from superhumans sh "
            + "join sightings s on sh.heroId = s.heroId "
            + "where s.locationId = ?";

    private static final String SQL_SELECT_SUPERHUMANS_BY_ORGANIZATION_ID
            = "select sh.heroId, sh.name, sh.description "
            + "from superhumans sh "
            + "join SuperhumansOrganizations so on o.heroId = so.heroId "
            + "where so.organizationId = ?";
        
    private static final String SQL_SELECT_ALL_SUPERHUMANS
            = "select * from superhmans";

    private static final String SQL_DELETE_SUPERHUMANS_POWERS
            = "delete from SuperhumansPowers where heroId = ?";
    
    private static final String SQL_INSERT_SIGHTING
            = "insert into sightings(date, heroId, locationId) "
            + "values (?, ?, ?)";
    
    private static final String SQL_DELETE_SIGHTING
            = "delete from sightings where sightingId = ?";
    
    private static final String SQL_UPDATE_SIGHTING
            = "update sightings set date = ?, heroId = ?, locationId = ? "
            + "where sightingId = ?";
    
    private static final String SQL_SELECT_SIGHTING
            = "select * from sightings where sightingId = ?";
    
    private static final String SQL_SELECT_SIGHTINGS_BY_LOCATION_ID
            = "select * from sightings where locationId = ?";
    
    private static final String SQL_SELECT_SIGHTINGS_BY_DATE
            = "select * from sightings where date = ?";
    
    private static final String SQL_SELECT_ALL_SIGHTINGS
            = "select * from sightings";
    
    private static final String SQL_INSERT_POWER
            = "insert into powers(description) "
            + "values (?)";
    
    private static final String SQL_INSERT_SUPERHUMANS_POWERS
            = "inset into SuperhumansPowers(heroId, powrId) "
            + "values (?, ?)";
    
    private static final String SQL_DELETE_POWER
            = "delete from powers where powerId = ?";

    private static final String SQL_UPDATE_POWER
            = "update powers set description = ? "
            + "where powerId = ?";
    
    private static final String SQL_SELECT_POWER
            = "select * from powers where powerId = ?";
    
    private static final String SQL_SELECT_ALL_POWERS
            = "select * from powers";
    
    private static final String SQL_INSERT_ORGANIZATION
            = "insert into organizations(name, description, address, "
            + "phone, email) values (?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_ORGANIZATION
            = "delete from organizations where organizationId = ?";
    
    private static final String SQL_UPDATE_ORGANIZATION
            = "update organizations set name = ?, description = ?, "
            + "address = ?, phone = ?, email = ? "
            + "where organizationId = ?";
    
    private static final String SQL_SELECT_ORGANIZATION
            = "select * from organizations where organizationId = ?";
    
    private static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "select * from organizations";
    
    private static final String SQL_INSERT_LOCATION
            = "insert into locations(name, description, address, "
            + "latitude, longitude) values (?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_LOCATION
            = "delete from locations where locationId = ?";
    
    private static final String SQL_UPDATE_LOCATION
            = "update locations set name = ?, description = ?, "
            + "address = ?, latitude = ?, longitude = ? "
            + "where locationId = ?";
    
    private static final String SQL_SELECT_LOCATION
            = "select * from locations where locationId = ?";
    
    private static final String SQL_SELECT_LOCATIONS_BY_HERO_ID
            = "select l.name, l.description, l.address, l.latitude, "
            + "l.longitude from locations l "
            + "join sightings s on l.locationId = s.locationId "
            + "where s.heroId = ?";
    
    private static final String SQL_SELECT_ALL_LOCATIONS
            = "select * from locations";
}
