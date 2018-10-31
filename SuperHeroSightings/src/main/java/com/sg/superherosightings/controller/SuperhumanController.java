/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Superhuman;
import com.sg.superherosightings.service.SuperheroSightingsService;
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

    SuperheroSightingsService service;

    @Inject
    public SuperhumanController(SuperheroSightingsService service) {
        this.service = service;
    }

    @RequestMapping(value = "/roguesgallery", method = RequestMethod.GET)
    public String displayRoguesGallery(Model model) {

        List<Superhuman> superhumanList = service.getAllSuperhumans();
        model.addAttribute("superhumanList", superhumanList);

        return "roguesgallery";
    }

    @RequestMapping(value = "/createsuperhuman", method = RequestMethod.GET)
    public String displayCreateSuperhumanPage(Model model) {
        List<Power> powerList = service.getAllPowers();
        List<Organization> organizationList = service.getAllOrganizations();

        model.addAttribute("powers", powerList);
        model.addAttribute("organizations", organizationList);
        return "createsuperhuman";
    }

    @RequestMapping(value = "/addsuperhuman", method = RequestMethod.POST)
    public String addSuperhuman(HttpServletRequest request, int[] powerIdList, int[] organizationIdList, Model model) {
        Superhuman superhuman = new Superhuman();
        superhuman.setName(request.getParameter("name"));
        superhuman.setDescription(request.getParameter("description"));

        List<Integer> powerList = new ArrayList<>();
        for (int powerId : powerIdList) {
            powerList.add(powerId);
        }

        superhuman.setPowers(powerList);

        List<Integer> organizationList = new ArrayList<>();
        for (int organizationId : organizationIdList) {
            organizationList.add(organizationId);
        }

        superhuman.setOrganizations(organizationList);

        service.addSuperhuman(superhuman);
        
        List<Superhuman> superhumanList = service.getAllSuperhumans();

        model.addAttribute("superhumanList", superhumanList);

        return "redirect: roguesgallery";
    }

    @RequestMapping(value = "/displayherodetails", method = RequestMethod.GET)
    public String displayHeroDetails(HttpServletRequest request, Model model) {
        String contactIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(contactIdParameter);

        Superhuman superhuman = service.getSuperhumanWihId(heroId);
        model.addAttribute("superhuman", superhuman);
        
        List<Power> heroPowers = service.getPowersOfHero(heroId);
        model.addAttribute("heroPowers", heroPowers);
        
        List<Organization> heroOrganizations = service.getOrganizationsOfHero(heroId);
        model.addAttribute("heroOrganizations", heroOrganizations);

        return "superherodetails";
    }

    @RequestMapping(value = "/deletehero", method = RequestMethod.GET)
    public String deleteHero(HttpServletRequest request) {
        String contactIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(contactIdParameter);
        
        service.deleteSuperhuman(heroId);
        
        return "redirect:roguesgallery";
    }
}
