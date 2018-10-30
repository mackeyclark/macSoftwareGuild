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
    
    public List<Power> getAllPowers();
    
    public List<Organization> getAllOrganizations();
    
    public List<Superhuman> getAllSuperhumans();
    
}
