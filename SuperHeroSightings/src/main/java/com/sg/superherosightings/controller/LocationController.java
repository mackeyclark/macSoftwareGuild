/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.service.SuperheroSightingsService;
import java.math.BigDecimal;
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
public class LocationController {

    SuperheroSightingsService service;

    @Inject
    public LocationController(SuperheroSightingsService service) {
        this.service = service;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String displayLocationPage(Model model) {

        List<Location> locationList = service.getAllLocations();
        model.addAttribute("locationList", locationList);

        return "locations";
    }

    @RequestMapping(value = "/createlocation", method = RequestMethod.GET)
    public String displayCreateLocationPage() {
        return "createlocation";
    }

    @RequestMapping(value = "/addlocation", method = RequestMethod.POST)
    public String addLocation(HttpServletRequest request) {
        Location location = new Location();
        location.setName(request.getParameter("name"));
        location.setDescription(request.getParameter("description"));
        location.setAddress(request.getParameter("address"));
        location.setLatitude(request.getParameter("latitude"));
        location.setLongitude(request.getParameter("longitude"));

        service.addLocation(location);

        return "redirect: locations";
    }

    @RequestMapping(value = "/deletelocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);

        service.deleteLocation(locationId);

        return "redirect: locations";
    }

    @RequestMapping(value = "/displaylocationdetails", method = RequestMethod.GET)
    public String displayLocationDetails(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);

        Location location = service.getLocationWithId(locationId);
        model.addAttribute("location", location);
        
        return "locationdetails";
    }
}
