/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author macam
 */
@Controller
public class LocationController {
    
    SuperheroSightingsDao dao;
    
    @Inject
    public LocationController(SuperheroSightingsDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String displayLocationPage() {
        return "locations";
    }
    
    @RequestMapping(value = "/createlocation", method = RequestMethod.GET)
    public String displayCreateLocationPage() {
        return "createlocation";
    }
    
}
