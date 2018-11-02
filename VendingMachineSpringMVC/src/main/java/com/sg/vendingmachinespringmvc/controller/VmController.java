/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.VmDao;
import com.sg.vendingmachinespringmvc.dao.VmPersistenceException;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.VmService;
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
public class VmController {
    
    VmDao dao;
    VmService service;
    
    @Inject
    public VmController(VmDao dao, VmService service) {
        this.dao = dao;
        this.service = service;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String displayItems(Model model) throws VmPersistenceException{
        //get all items from dao
        List<Item> itemList = dao.getProducts();
        
        model.addAttribute("itemList", itemList);
        
        return "index";
    }
    
    @RequestMapping(value="/venditem", method=RequestMethod.POST)
    public String vendItem(HttpServletRequest request) throws InsufficentFundsException, NoItemInventoryException, VmPersistenceException {
        //grab the incoming values of user change input and item input and
        //create a new change objext once they've been validated
        String change = request.getParameter("moneyIn");
        int money = Integer.parseInt(change);
        
        
        
//        Item item = new Item();
//        Change returnChange = service.vend(money ,item);
        
        return "index";
    }
}