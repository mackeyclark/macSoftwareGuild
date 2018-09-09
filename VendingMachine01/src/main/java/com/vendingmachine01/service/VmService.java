/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.service;

import com.vendingmachine01.dao.VmPersistenceException;
import com.vendingmachine01.dto.Change;
import com.vendingmachine01.dto.Item;
import java.util.List;

/**
 *
 * @author macam
 */
public interface VmService {

    public Change vend(int money, Item selectItem) throws InsufficentFundsException, NoItemInventoryException, VmPersistenceException;

    public List<Item> getProducts() throws VmPersistenceException;
    
}
