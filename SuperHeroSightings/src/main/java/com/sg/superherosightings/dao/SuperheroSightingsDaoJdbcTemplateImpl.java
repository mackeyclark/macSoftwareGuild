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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

    @Override
    public void addSuperhuman(Superhuman superhuman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSuperhuman(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSuperhuman(Superhuman superhuman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Superhuman getSuperhumanWithId(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Superhuman> getAllSuperhumans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Superhuman> getAllSuperhumansInOrganization(int organizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSighting(Sighting sighting, LocalDate date, int locationId, int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSighting(int sightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSighting(Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sighting getSightingWithId(int sightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sighting> getAllSightings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sighting> getAllSightingsOfLocation(int locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sighting> getAllSightingsOnDate(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePower(int powerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power getPowerWithId(int powerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Power> getAllPowers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrganization(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOrganization(int organizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrganization(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization getOrganizationWithId(int organizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organization> getAllOrganizations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organization> getOrganizationsOfSuperhuman(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLocation(int locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getLocationWithId(int locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getLocationsOfSuperhuman(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class SuperhumanMapper implements RowMapper<Superhuman> {

        @Override
        public Superhuman mapRow(ResultSet rs, int i) throws SQLException {
            Superhuman sh = new Superhuman();
            sh.setName(rs.getString("name"));
            sh.setDescription(rs.getString("description"));
            sh.setHeroId(rs.getInt("heroId"));
            return sh;
        }
        
    }
    
    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting s = new Sighting();
            s.setDate(rs.getTimestamp("date").toLocalDateTime().toLocalDate());
            s.setSightingId(rs.getInt("sightingId"));
            return s;
        }
        
    }
    
    private static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power p = new Power();
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPowerId(rs.getInt("powerId"));
            return p;
        }
        
    }
    
    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization o = new Organization();
            o.setName(rs.getString("name"));
            o.setDescription(rs.getString("description"));
            o.setAddress(rs.getString("address"));
            o.setPhone(rs.getString("phone"));
            o.setEmail(rs.getString("email"));
            o.setOrganizationId(rs.getInt("organizationId"));
            return o;
        }
        
    }
    
    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location l = new Location();
            l.setName(rs.getString("name"));
            l.setDescription(rs.getString("description"));
            l.setAddress(rs.getString("address"));
            l.setLatitude(rs.getBigDecimal("latitude"));
            l.setLongitude(rs.getBigDecimal("longitude"));
            l.setLocationId(rs.getInt("locationId"));
            return l;
        }
        
    }
    
}
