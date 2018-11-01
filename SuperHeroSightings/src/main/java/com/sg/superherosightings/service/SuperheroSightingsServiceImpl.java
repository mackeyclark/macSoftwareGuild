/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Superhuman;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author macam
 */
@Service
public class SuperheroSightingsServiceImpl implements SuperheroSightingsService {
    
    SuperheroSightingsDao dao;
    
    @Inject
    public SuperheroSightingsServiceImpl(SuperheroSightingsDao dao) {
        this.dao = dao;
    }

    @Override
    public void addSuperhuman(Superhuman superhuman) {
        dao.addSuperhuman(superhuman);
    }

    @Override
    public List<Power> getAllPowers() {
        return dao.getAllPowers();
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return dao.getAllOrganizations();
    }

    @Override
    public List<Superhuman> getAllSuperhumans() {
        return dao.getAllSuperhumans();
    }

    @Override
    public void addPower(Power power) {
        dao.addPower(power);
    }

    @Override
    public void addOrganization(Organization organization) {
        dao.addOrganization(organization);
    }

    @Override
    public Superhuman getSuperhumanWihId(int heroId) {
        return dao.getSuperhumanWithId(heroId);
    }

    @Override
    public void deleteSuperhuman(int heroId) {
        dao.deleteSuperhuman(heroId);
    }

    @Override
    public List<Power> getPowersOfHero(int heroId) {
        return dao.getPowersOfHero(heroId);
    }

    @Override
    public List<Organization> getOrganizationsOfHero(int heroId) {
        return dao.getOrganizationsOfSuperhuman(heroId);
    }

    @Override
    public Organization getOrganizationWithId(int organizationId) {
        return dao.getOrganizationWithId(organizationId);
    }

    @Override
    public void deleteOrganization(int organizationId) {
        dao.deleteOrganization(organizationId);
    }

    @Override
    public List<Location> getAllLocations() {
        return dao.getAllLocations();
    }

    @Override
    public void addLocation(Location location) {
        dao.addLocation(location);
    }

    @Override
    public void deletePower(int powerId) {
        dao.deletePower(powerId);
    }

    @Override
    public void deleteLocation(int locationId) {
        dao.deleteLocation(locationId);
    }

    @Override
    public Location getLocationWithId(int locationId) {
        return dao.getLocationWithId(locationId);
    }
    
}
