/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcrevised.service;

import com.sg.vendingmachinespringmvcrevised.dto.Change;
import com.sg.vendingmachinespringmvcrevised.dto.Item;
import java.util.List;

/**
 *
 * @author macam
 */
public interface VmService {
    
    public Change vend(int money, Item selectItem) throws InsufficentFundsException, NoItemInventoryException;

    public List<Item> getAllProducts();
    
}
