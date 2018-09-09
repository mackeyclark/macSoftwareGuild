/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.controller;

import com.vendingmachine01.dao.VmPersistenceException;
import com.vendingmachine01.dto.Change;
import com.vendingmachine01.dto.Item;
import com.vendingmachine01.service.InsufficentFundsException;
import com.vendingmachine01.service.NoItemInventoryException;
import com.vendingmachine01.service.VmService;
import com.vendingmachine01.view.VmView;
import java.util.List;

/**
 *
 * @author macam
 */
public class VmControllerImpl implements VmController {

    VmService service = null;
    VmView view = null;

    public VmControllerImpl(VmService service, VmView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void run() {
        boolean keepGoing = true;

        while (keepGoing) {
            try {
                //Step 0. Display items
                List<Item> products = service.getProducts();
                view.printProducts(products);
                //Step 1. Have user select item
                Item selectItem = view.selectItem(products);
                //Step 2. Have user insert money
                int moneyAsPennies = view.getMoneyAsPennies();
                //Step 3. Vend item
                Change returnChange = service.vend(moneyAsPennies, selectItem);
                //Step 4. Dispense change
                view.showChange(returnChange);
                //Step 5. Loop unless done

            } catch (VmPersistenceException | InsufficentFundsException | NoItemInventoryException e) {
                view.displayErrorMessage(e.getMessage());
            }
            keepGoing = view.askKeepGoing();
        }

    }

}