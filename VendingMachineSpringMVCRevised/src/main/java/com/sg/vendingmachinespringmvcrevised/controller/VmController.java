/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcrevised.controller;

import com.sg.vendingmachinespringmvcrevised.dao.VmDao;
import com.sg.vendingmachinespringmvcrevised.dto.Item;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author macam
 */

@Controller
public class VmController {
    
    VmDao dao;
    
    @Inject
    public VmController(VmDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String displayAllItems(Model model) {
        List<Item> itemList = dao.getAllProducts();
        
        model.addAttribute("itemList", itemList);
        
        return "index";
    }
    
    
}
