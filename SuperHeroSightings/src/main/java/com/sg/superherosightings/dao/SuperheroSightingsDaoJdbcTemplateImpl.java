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
//@Repository
public class SuperheroSightingsDaoJdbcTemplateImpl implements SuperheroSightingsDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
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
            = "select * from superhumans";

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
            = "insert into powers(name, description) "
            + "values (?, ?)";

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

    private static final String SQL_SELECT_ORGANIZATIONS_BY_HERO_ID
            = "select o.name, o.description, o.address, o. phone, "
            + "o.email from organizations o "
            + "join superhumansorganizations so on o.organizationId = so.organizationId "
            + "where so.heroId = ?";

    private static final String SQL_DELETE_SUPERHUMANS_ORGANIZATIONS
            = "delete from superhumansorganizations where organizationId = ?";

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
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperhuman(Superhuman superhuman) {
        jdbcTemplate.update(SQL_INSERT_SUPERHUMAN,
                superhuman.getName(),
                superhuman.getDescription());

        int heroId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        superhuman.setHeroId(heroId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSuperhuman(int heroId) {
        jdbcTemplate.update(SQL_DELETE_SUPERHUMAN, heroId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSuperhuman(Superhuman superhuman) {
        jdbcTemplate.update(SQL_UPDATE_SUPERHUMAN,
                superhuman.getName(),
                superhuman.getDescription(),
                superhuman.getHeroId());
    }

    @Override
    public Superhuman getSuperhumanWithId(int heroId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERHUMAN, new SuperhumanMapper(), heroId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Superhuman> getAllSuperhumans() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERHUMANS, new SuperhumanMapper());
    }

    @Override
    public List<Superhuman> getAllSuperhumansInOrganization(int organizationId) {
        return jdbcTemplate.query(SQL_SELECT_SUPERHUMANS_BY_ORGANIZATION_ID, new SuperhumanMapper(), organizationId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSighting(Sighting sighting) {
//        jdbcTemplate.update(SQL_INSERT_SIGHTING,
//                sighting.getDate().toString(),
////                sighting.getSuperhuman().getHeroId(),
////                sighting.getLocation().getLocationId());
//
////        int sightingId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
//
////        sighting.setSightingId(sightingId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sighting.getDate().toString(),
//                sighting.getSuperhuman().getHeroId(),
//                sighting.getLocation().getLocationId(),
                sighting.getSightingId());

    }

    @Override
    public Sighting getSightingWithId(int sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING, new SightingMapper(), sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
    }

    @Override
    public List<Sighting> getAllSightingsOfLocation(int locationId) {
        try {
            return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_BY_LOCATION_ID, new SightingMapper(), locationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightingsOnDate(LocalDate date) {
        try {
            return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_BY_DATE, new SightingMapper(), date);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPower(Power power) {
        jdbcTemplate.update(SQL_INSERT_POWER,
                power.getName(),
                power.getDescription());

        int powerId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        power.setPowerId(powerId);

        insertSuperhumansPowers(power);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePower(int powerId) {
        jdbcTemplate.update(SQL_DELETE_SUPERHUMANS_POWERS, powerId);

        jdbcTemplate.update(SQL_DELETE_POWER, powerId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updatePower(Power power) {
        jdbcTemplate.update(SQL_UPDATE_POWER,
                power.getName(),
                power.getDescription(),
                power.getPowerId());

        jdbcTemplate.update(SQL_DELETE_SUPERHUMANS_POWERS, power.getPowerId());
        insertSuperhumansPowers(power);

    }

    @Override
    public Power getPowerWithId(int powerId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POWER, new PowerMapper(), powerId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Power> getAllPowers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POWERS, new PowerMapper());
    }

    @Override
    public void addOrganization(Organization organization) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                organization.getName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getEmail(),
                organization.getPhone());

        int organizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        organization.setOrganizationId(organizationId);

        insertSuperhumansOrganizations(organization);
    }

    @Override
    public void deleteOrganization(int organizationId) {
        jdbcTemplate.update(SQL_DELETE_SUPERHUMANS_ORGANIZATIONS, organizationId);

        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationId);
    }

    @Override
    public void updateOrganization(Organization organization) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                organization.getName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getEmail(),
                organization.getPhone(),
                organization.getOrganizationId());

        jdbcTemplate.update(SQL_DELETE_SUPERHUMANS_ORGANIZATIONS, organization.getOrganizationId());

        insertSuperhumansOrganizations(organization);
    }

    @Override
    public Organization getOrganizationWithId(int organizationId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION, new OrganizationMapper(), organizationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
    }

    @Override
    public List<Organization> getOrganizationsOfSuperhuman(int heroId) {
        return jdbcTemplate.query(SQL_SELECT_ORGANIZATIONS_BY_HERO_ID, new OrganizationMapper(), heroId);
    }

    @Override
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getLatitude(),
                location.getLongitude());

        int locationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        location.setLocationId(locationId);
    }

    @Override
    public void deleteLocation(int locationId) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getLatitude(),
                location.getLongitude(),
                location.getLocationId());
    }

    @Override
    public Location getLocationWithId(int locationId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION, new LocationMapper(), locationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public List<Location> getLocationsOfSuperhuman(int heroId) {
        try {
            return jdbcTemplate.query(SQL_SELECT_LOCATIONS_BY_HERO_ID, new LocationMapper(), heroId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //Helper methods
    private void insertSuperhumansPowers(Power power) {
        final int powerId = power.getPowerId();
        final Superhuman superhuman = power.getSuperhuman();

        jdbcTemplate.update(SQL_INSERT_SUPERHUMANS_POWERS, powerId, superhuman.getHeroId());

//        final int heroId = superhuman.getHeroId();
//        final List<Power> power = superhuman.getPowers();
//
//        jdbcTemplate.update(SQL_INSERT_SUPERHUMANS_POWERS, heroId, superhuman.getPowers());
    }

    private static final String SQL_INSERT_SUPERHUMANS_ORGANIZATIONS
            = "insert into superhumansorganizations(heroId, organizationId) "
            + "values (?, ?)";

    private void insertSuperhumansOrganizations(Organization organization) {
        final int organizationId = organization.getOrganizationId();
        final Superhuman superhuman = organization.getSuperhuman();

        jdbcTemplate.update(SQL_INSERT_SUPERHUMANS_ORGANIZATIONS, organizationId, superhuman.getHeroId());
    }

    private List<Organization> findOrganizationsForSuperhuman(Superhuman superhuman) {
        return jdbcTemplate.query(SQL_SELECT_ORGANIZATIONS_BY_HERO_ID, new OrganizationMapper(), superhuman.getHeroId());
    }

    @Override
    public List<Power> getPowersOfHero(int heroId) {
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
            l.setLatitude(rs.getString("latitude"));
            l.setLongitude(rs.getString("longitude"));
            l.setLocationId(rs.getInt("locationId"));
            return l;
        }

    }

}
