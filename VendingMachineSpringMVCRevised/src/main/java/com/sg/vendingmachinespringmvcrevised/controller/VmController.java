/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcrevised.controller;

import com.sg.vendingmachinespringmvcrevised.dto.Change;
import com.sg.vendingmachinespringmvcrevised.dto.Item;
import com.sg.vendingmachinespringmvcrevised.service.InsufficentFundsException;
import com.sg.vendingmachinespringmvcrevised.service.NoItemInventoryException;
import com.sg.vendingmachinespringmvcrevised.service.VmService;
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
public class VmController {

    VmService service;

    @Inject
    public VmController(VmService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String displayAllItems(Model model) {
        List<Item> itemList = service.getAllProducts();

        model.addAttribute("itemList", itemList);

        return "index";
    }

    @RequestMapping(value = "/venditem", method = RequestMethod.POST)
    public String vendItem(HttpServletRequest request, Model model) throws InsufficentFundsException, NoItemInventoryException {
        //grab the incoming values of user change input and item input and
        //create a new change objext once they've been validated
        String name = request.getParameter("itemName");

        int money;
        if (!request.getParameter("totalInserted").isEmpty()) {
            String change = request.getParameter("totalInserted");
            money = new BigDecimal(change).multiply(new BigDecimal(100)).intValue();
        } else {
            money = 0;
        }

        String itemId = request.getParameter("itemId");
        int id = Integer.parseInt(itemId);

        String itemPrice = request.getParameter("itemPrice");
        
        int price = new BigDecimal(itemPrice).multiply(new BigDecimal(100)).intValue();

        String itemInventory = request.getParameter("itemInventory");
        int inventory = Integer.parseInt(itemInventory);

        Item item = new Item(id, name, price, inventory);

        try {
            Change returnChange = service.vend(money, item);
            model.addAttribute("returnChange", returnChange);
        } catch (InsufficentFundsException | NoItemInventoryException ex) {
            String exceptionError = ex.getMessage();
            model.addAttribute("exceptionError", exceptionError);
        }

        return "redirect: index";
    }

}
