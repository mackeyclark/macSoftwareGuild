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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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
            final String INSERT_SUPERHUMANSORGANIZATIONS = "insert into superhumansorganizations (heroId, organizationId) values (?, ?)";

            jdbcTemplate.update(INSERT_SUPERHUMANSORGANIZATIONS, superhuman.getHeroId(), organizationId);
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSuperhuman(int heroId) {
        final String DELETE_SUPERHUMANSPOWERS = "delete from superhumanspowers where heroId = ?";
        final String DELETE_SUPERHUMANSORGANIZATIONS = "delete from superhumansorganizations where heroId = ?";
        final String DELETE_SUPERHUMAN = "delete from superhumans where heroId = ?";

        jdbcTemplate.update(DELETE_SUPERHUMANSPOWERS, heroId);
        jdbcTemplate.update(DELETE_SUPERHUMANSORGANIZATIONS, heroId);
        jdbcTemplate.update(DELETE_SUPERHUMAN, heroId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSuperhuman(Superhuman superhuman) {
        final String UPDATE_SUPERHUMAN = "update superhumans set name = ?, description = ? where heroId = ?";

        jdbcTemplate.update(UPDATE_SUPERHUMAN,
                superhuman.getName(),
                superhuman.getDescription(),
                superhuman.getHeroId());

        final String DELETE_SUPERHUMANSPOWERS = "delete from superhumanspowers where heroId = ?";
        jdbcTemplate.update(DELETE_SUPERHUMANSPOWERS, superhuman.getHeroId());

        for (int powerId : superhuman.getPowers()) {
            final String INSERT_SUPERHUMANSPOWERS = "insert into superhumanspowers (heroId, powerId) values (?, ?)";

            jdbcTemplate.update(INSERT_SUPERHUMANSPOWERS, superhuman.getHeroId(), powerId);
        }

        final String DELETE_SUPERHUMANSORGANIZATIONS = "delete from superhumansorganizations where heroId = ?";
        jdbcTemplate.update(DELETE_SUPERHUMANSORGANIZATIONS, superhuman.getHeroId());

        for (int organizationId : superhuman.getOrganizations()) {
            final String INSERT_SUPERHUMANSORGANIZATIONS = "insert into superhumansorganizations (heroId, organizationId) values (?, ?)";

            jdbcTemplate.update(INSERT_SUPERHUMANSORGANIZATIONS, superhuman.getHeroId(), organizationId);
        }

    }

    @Override
    public Superhuman getSuperhumanWithId(int heroId) {

        final String SELECT_SUPERHUMAN = "select * from superhumans where heroId = ?";
        final String SELECT_POWERS_BY_HERO_ID = "select powerId from superhumanspowers where heroId = ?";
        final String SELECT_ORGANIZATIONS_BY_HERO_ID = "select organizationId from superhumansorganizations where heroId = ?";

        try {

            Superhuman superhuman = jdbcTemplate.queryForObject(SELECT_SUPERHUMAN, new SuperhumanMapper(), heroId);
            superhuman.setPowers(jdbcTemplate.queryForList(SELECT_POWERS_BY_HERO_ID, Integer.class, heroId));
            superhuman.setOrganizations(jdbcTemplate.queryForList(SELECT_ORGANIZATIONS_BY_HERO_ID, Integer.class, heroId));

            return superhuman;

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Superhuman> getAllSuperhumans() {
        final String SELECT_ALL_SUPERHUMANS = "select * from superhumans";
        return jdbcTemplate.query(SELECT_ALL_SUPERHUMANS, new SuperhumanMapper());
    }

    @Override
    public List<Superhuman> getAllSuperhumansInOrganization(int organizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSighting(Sighting sighting) {
        final String INSERT_SIGHTING = "insert into sightings(date, heroId, locationId) values (?, ?, ?)";

        jdbcTemplate.update(INSERT_SIGHTING,
                sighting.getDate(),
                sighting.getHeroId(),
                sighting.getLocationId());

        int sightingId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        sighting.setSightingId(sightingId);
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
        final String SELECT_ALL_SIGHTINGS = "select * from sightings";

        return jdbcTemplate.query(SELECT_ALL_SIGHTINGS, new SightingMapper());
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
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPower(Power power) {
        final String SQL_INSERT_POWER = "insert into powers(name, description) values (?, ?)";
        jdbcTemplate.update(SQL_INSERT_POWER,
                power.getName(),
                power.getDescription());

        int powerId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        power.setPowerId(powerId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePower(int powerId) {
        final String DELETE_POWER = "delete from powers where powerId = ?";

        jdbcTemplate.update(DELETE_POWER, powerId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updatePower(Power power) {
        final String UPDATE_POWER = "update powers set name = ?, description = ? where powerId = ?";

        jdbcTemplate.update(UPDATE_POWER,
                power.getName(),
                power.getDescription(),
                power.getPowerId());

    }

    @Override
    public Power getPowerWithId(int powerId) {
        final String SELECT_POWER = "select * from powers where powerId = ?";

        try {
            return jdbcTemplate.queryForObject(SELECT_POWER, new PowerMapper(), powerId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Power> getAllPowers() {
        final String SELECT_ALL_POWERS = "select * from powers";

        return jdbcTemplate.query(SELECT_ALL_POWERS, new PowerMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization organization) {
        final String SQL_INSERT_ORGANIZATION = "insert into organizations(name, description, address, "
                + "phone, email) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                organization.getName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getPhone(),
                organization.getEmail());

        int organizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        organization.setOrganizationId(organizationId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteOrganization(int organizationId) {
        final String DELETE_ORGANIZATION = "delete from organizations where organizationId = ?";

        jdbcTemplate.update(DELETE_ORGANIZATION, organizationId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateOrganization(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization getOrganizationWithId(int organizationId) {
        final String SELECT_ORGANIZATION = "select * from organizations where organizationId = ?";

        try {
            return jdbcTemplate.queryForObject(SELECT_ORGANIZATION, new OrganizationMapper(), organizationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Organization> getAllOrganizations() {
        final String SELECT_ALL_ORGANIZATIONS = "select * from organizations";

        return jdbcTemplate.query(SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
    }

    @Override
    public List<Organization> getOrganizationsOfSuperhuman(int heroId) {
        final String SELECT_ORGANIZATIONS_BY_HERO_ID = "select * from organizations where organizationId in (select organizationId from superhumansorganizations where heroId = ?)";

        return jdbcTemplate.query(SELECT_ORGANIZATIONS_BY_HERO_ID, new OrganizationMapper(), heroId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        final String INSERT_LOCATION = "insert into locations(name, description, address, latitude, longitude) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(INSERT_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getLatitude(),
                location.getLongitude());

        int locationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        location.setLocationId(locationId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteLocation(int locationId) {
        final String DELETE_LOCATION = "delete from locations where locationId = ?";

        jdbcTemplate.update(DELETE_LOCATION, locationId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getLocationWithId(int locationId) {
        final String SELECT_LOCATION = "select * from locations where locationId = ?";

        try {
            return jdbcTemplate.queryForObject(SELECT_LOCATION, new LocationMapper(), locationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        final String SELECT_ALL_LOCATIONS = "select * from locations";

        return jdbcTemplate.query(SELECT_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public List<Location> getLocationsOfSuperhuman(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void clearAllData() {

        final String DELETE_ALL_FROM_SUPERHUMANSPOWERS = "delete from superhumanspowers";
        jdbcTemplate.update(DELETE_ALL_FROM_SUPERHUMANSPOWERS);

        final String DELETE_ALL_FROM_SUPERHUMANSORGANIZATIONS = "delete from superhumansorganizations";
        jdbcTemplate.update(DELETE_ALL_FROM_SUPERHUMANSORGANIZATIONS);

        final String DELETE_ALL_FROM_SUPERHUMANS = "delete from superhumans";
        jdbcTemplate.update(DELETE_ALL_FROM_SUPERHUMANS);

        final String DELETE_ALL_FROM_POWERS = "delete from powers";
        jdbcTemplate.update(DELETE_ALL_FROM_POWERS);

        final String DELETE_ALL_FROM_ORGANIZATIONS = "delete from organizations";
        jdbcTemplate.update(DELETE_ALL_FROM_ORGANIZATIONS);

        final String DELETE_ALL_FROM_LOCATIONS = "delete from locations";
        jdbcTemplate.update(DELETE_ALL_FROM_LOCATIONS);

        final String DELETE_ALL_FROM_SIGHTINGS = "delete from sightings";
        jdbcTemplate.update(DELETE_ALL_FROM_SIGHTINGS);

    }

    @Override
    public List<Power> getPowersOfHero(int heroId) {
        final String SELECT_POWERS_BY_HERO_ID = "select * from powers where powerId in (select powerId from superhumanspowers where heroId = ?)";

        return jdbcTemplate.query(SELECT_POWERS_BY_HERO_ID, new PowerMapper(), heroId);
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
            l.setLatitude(rs.getString("latitude"));
            l.setLongitude(rs.getString("longitude"));
            l.setLocationId(rs.getInt("locationId"));
            return l;
        }

    }

}
