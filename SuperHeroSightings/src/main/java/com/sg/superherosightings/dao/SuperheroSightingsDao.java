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
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author macam
 */
public interface SuperheroSightingsDao {
    
    public void addSuperhuman(Superhuman superhuman);
    
    public void deleteSuperhuman(int heroId);
    
    public void updateSuperhuman(Superhuman superhuman);
    
    public Superhuman getSuperhumanWithId(int heroId);
    
    public List<Superhuman> getAllSuperhumans();
    
    public List<Superhuman> getAllSuperhumansInOrganization(int organizationId);
    
    public void addSighting(Sighting sighting, LocalDate date, int locationId, int heroId);
    
    public void deleteSighting(int sightingId);
    
    public void updateSighting(Sighting sighting);
    
    public Sighting getSightingWithId(int sightingId);
    
    public List<Sighting> getAllSightings();
    
    public List<Sighting> getAllSightingsOfLocation(int locationId);
    
    public List<Sighting> getAllSightingsOnDate(LocalDate date);
    
    public void addPower(Power power);
    
    public void deletePower(int powerId);
    
    public void updatePower(Power power);
    
    public Power getPowerWithId(int powerId);
    
    public List<Power> getAllPowers();
    
    public void addOrganization(Organization organization);
    
    public void deleteOrganization(int organizationId);
    
    public void updateOrganization(Organization organization);
    
    public Organization getOrganizationWithId(int organizationId);
    
    public List<Organization> getAllOrganizations();
    
    public List<Organization> getOrganizationsOfSuperhuman(int heroId);
    
    public void addLocation(Location location);
    
    public void deleteLocation(int locationId);
    
    public void updateLocation(Location location);
    
    public Location getLocationWithId(int locationId);
    
    public List<Location> getAllLocations();
    
    public List<Location> getLocationsOfSuperhuman(int heroId);
    
}
