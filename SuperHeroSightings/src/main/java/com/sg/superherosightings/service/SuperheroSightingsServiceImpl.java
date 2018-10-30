/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
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
    
}
