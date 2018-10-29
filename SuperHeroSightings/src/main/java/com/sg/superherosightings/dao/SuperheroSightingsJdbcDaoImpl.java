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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macam
 */
@Repository
public class SuperheroSightingsJdbcDaoImpl implements SuperheroSightingsDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addSuperhuman(Superhuman superhuman) {
        final String INSERT_SUPERHUMAN = "insert into superhumans (name, description) values (?, ?)";
        jdbcTemplate.update(INSERT_SUPERHUMAN,
                superhuman.getName(),
                superhuman.getDescription());

        int heroId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        superhuman.setHeroId(heroId);

        for (int powerId : superhuman.getPowers()) {
            final String INSERT_SUPERHUMANSPOWERS = "insert into superhumanspowers (heroId, powerId) values (?, ?)";

            jdbcTemplate.update(INSERT_SUPERHUMANSPOWERS, superhuman.getHeroId(), powerId);
        }

        for (int organizationId : superhuman.getOrganizations()) {
            final String INSERT_SUPERHUMANSORGANIZATIONS = "insert into superhumansorganizations (heroId, organizationId) valuse (?, ?)";

            jdbcTemplate.update(INSERT_SUPERHUMANSORGANIZATIONS, superhuman.getHeroId(), organizationId);
        }

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
    public void addSighting(Sighting sighting) {
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
        final String SQL_INSERT_POWER = "insert into powers(name, description) values (?, ?)";
        jdbcTemplate.update(SQL_INSERT_POWER,
                power.getName(),
                power.getDescription());

        int powerId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        power.setPowerId(powerId);
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
        final String SELECT_ALL_POWERS = "select * from powers";

        return jdbcTemplate.query(SELECT_ALL_POWERS, new PowerMapper());
    }

    @Override
    public void addOrganization(Organization organization) {
        final String SQL_INSERT_ORGANIZATION = "insert into organizations(name, description, address, "
                + "phone, email) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                organization.getName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getEmail(),
                organization.getPhone());

        int organizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        organization.setOrganizationId(organizationId);
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
        final String SELECT_ALL_ORGANIZATIONS = "select * from organizations";
        
        return jdbcTemplate.query(SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
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

    //Mappers
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
