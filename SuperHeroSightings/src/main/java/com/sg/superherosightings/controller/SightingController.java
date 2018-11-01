/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.Superhuman;
import com.sg.superherosightings.service.SuperheroSightingsService;
import java.time.LocalDate;
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
public class SightingController {
    
    SuperheroSightingsService service;
    
    @Inject
    public SightingController(SuperheroSightingsService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/sightings", method = RequestMethod.GET)
    public String displaySightingsPage(Model model) {
        
        List<Sighting> sightingList = service.getAllSightings();
        model.addAttribute("sightingList", sightingList);
        
        return "sightings";
    }
    
    @RequestMapping(value = "/createsighting", method = RequestMethod.GET)
    public String displayCreateSightingPage(Model model) {
        List<Superhuman> superhumanList = service.getAllSuperhumans();
        List<Location> locationList = service.getAllLocations();
        
        model.addAttribute("superhumanList", superhumanList);
        model.addAttribute("locationList", locationList);
        
        return "createsighting";
    }
    
    @RequestMapping(value = "/addsighting", method = RequestMethod.POST)
    public String addSighting(HttpServletRequest request, Model model, int heroId, int locationId) {
        Sighting sighting = new Sighting();
        
        String date = request.getParameter("date");
        LocalDate sightingDate = LocalDate.parse(date);
        
        sighting.setDate(sightingDate);
        sighting.setHeroId(heroId);
        sighting.setLocationId(locationId);
        
        service.addSighting(sighting);
        
        List<Sighting> sightingList = service.getAllSightings();
        
        model.addAttribute("sightingList", sightingList);
        
        return "redirect: sightings";
    }
}
