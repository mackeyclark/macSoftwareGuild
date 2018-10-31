/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.service.SuperheroSightingsService;
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
public class OrganizationController {
    
    SuperheroSightingsService service;
    
    @Inject
    public OrganizationController(SuperheroSightingsService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public String displayOrganizationsPage(Model model) {
        
        List<Organization> organizationList = service.getAllOrganizations();
        model.addAttribute("organizationList", organizationList);
        
        return "organizations";
    }
    
    @RequestMapping(value = "/createorganization", method = RequestMethod.GET)
    public String displayCreateOrganizationPage() {
        return "createorganization";
    }
    
    @RequestMapping(value = "/addorganization", method = RequestMethod.POST)
    public String addOrganization(HttpServletRequest request) {
        Organization organization = new Organization();
        organization.setName(request.getParameter("name"));
        organization.setDescription(request.getParameter("description"));
        organization.setAddress(request.getParameter("address"));
        organization.setPhone(request.getParameter("phone"));
        organization.setEmail(request.getParameter("email"));
        
        service.addOrganization(organization);
        
        return "redirect: organizations";
    }
}
