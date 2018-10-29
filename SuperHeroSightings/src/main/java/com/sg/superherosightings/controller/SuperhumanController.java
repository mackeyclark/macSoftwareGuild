/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Superhuman;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String displayCreateSuperhumanPage(Model model) {
        List<Power> powerList = dao.getAllPowers();
        List<Organization> organizationList = dao.getAllOrganizations();
        
        model.addAttribute("powers", powerList);
        model.addAttribute("organizations", organizationList);
        return "createsuperhuman";
    }
    
    @RequestMapping(value="/addsuperhuman", method=RequestMethod.POST)
    public String addSuperhuman(HttpServletRequest request, int[] powerIdList, int[] organizationIdList) {
        Superhuman superhuman = new Superhuman();
        superhuman.setName(request.getParameter("name"));
        superhuman.setDescription(request.getParameter("description"));
        
        List<Integer> powerList = new ArrayList<>();
        for(int powerId : powerIdList) {
            powerList.add(powerId);
        }
        
        superhuman.setPowers(powerList);
        
        List<Integer> organizationList = new ArrayList<>();
        for(int organizationId : organizationIdList) {
            organizationList.add(organizationId);
        }
        
        superhuman.setOrganizations(organizationList);
        
        dao.addSuperhuman(superhuman);
        
        return "roguesgallery";
    }
}
