/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author macam
 */
@Controller
public class SuperhumanController {
    
    @RequestMapping(value="/roguesgallery", method=RequestMethod.GET)
    public String displayRoguesGallery() {
        return "roguesgallery";
    }
    
    @RequestMapping(value="/createsuperhuman", method=RequestMethod.GET)
    public String displayCreateSuperhumanPage() {
        return "createsuperhuman";
    }
}
