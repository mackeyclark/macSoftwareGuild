/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.controller.InsufficentFundsException;
import com.sg.vendingmachinespringmvc.controller.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.dao.VmPersistenceException;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;

/**
 *
 * @author macam
 */
public interface VmService {

    public Change vend(int money, Item selectItem) throws InsufficentFundsException, NoItemInventoryException, VmPersistenceException;

    public List<Item> getProducts() throws VmPersistenceException;
    
}
