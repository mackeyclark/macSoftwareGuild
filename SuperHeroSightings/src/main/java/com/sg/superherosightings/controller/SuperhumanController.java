/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.Superhuman;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author macam
 */
@Controller
public class SuperhumanController {
    
    SuperheroSightingsDao dao;
    
    @Inject
    public SuperhumanController(SuperheroSightingsDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/roguesgallery", method=RequestMethod.GET)
    public String displayRoguesGallery() {
        return "roguesgallery";
    }
    
    @RequestMapping(value="/createsuperhuman", method=RequestMethod.GET)
    public String displayCreateSuperhumanPage() {
        return "createsuperhuman";
    }
    
    @RequestMapping(value="/addsuperhuman", method=RequestMethod.POST)
    public String addSuperhuman(HttpServletRequest request) {
        Superhuman superhuman = new Superhuman();
        superhuman.setName(request.getParameter("name"));
        superhuman.setDescription(request.getParameter("description"));
//        superhuman.setPowers(request.getParameter("power"));
//        superhuman.setOrganizations(request.getParameter("organization"));
        
        dao.addSuperhuman(superhuman);
        
        return "roguesgallery";
    }
}
