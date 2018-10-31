/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Superhuman;
import java.util.List;

/**
 *
 * @author macam
 */
public interface SuperheroSightingsService {
    
    public void addSuperhuman(Superhuman superhuman);
    
    public void addPower(Power power);
    
    public List<Power> getAllPowers();
    
    public List<Organization> getAllOrganizations();
    
    public List<Superhuman> getAllSuperhumans();

    public void addOrganization(Organization organization);

    public Superhuman getSuperhumanWihId(int heroId);

    public void deleteSuperhuman(int heroId);

    public List<Power> getPowersOfHero(int heroId);

    public List<Organization> getOrganizationsOfHero(int heroId);

    public Organization getOrganizationWithId(int organizationId);

    public void deleteOrganization(int organizationId);
    
}
