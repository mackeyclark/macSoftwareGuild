/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.Power;
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
public class PowerController {

    SuperheroSightingsDao dao;

    @Inject
    public PowerController(SuperheroSightingsDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/powerlist", method = RequestMethod.GET)
    public String displayPowerlistPage() {
        return "powerlist";
    }

    @RequestMapping(value = "/createpower", method = RequestMethod.GET)
    public String displayCreatePowerPage() {
        return "createpower";
    }

    @RequestMapping(value = "/addpower", method = RequestMethod.POST)
    public String addPower(HttpServletRequest request) {
        Power power = new Power();
        power.setName(request.getParameter("name"));
        power.setDescription(request.getParameter("description"));
        
        dao.addPower(power);
        
        return "powerlist";
    }
}
