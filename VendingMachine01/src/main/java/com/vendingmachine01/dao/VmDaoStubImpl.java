/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.dao;

import com.vendingmachine01.dto.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macam
 */
public class VmDaoStubImpl implements VmDao {
    
    Item onlyItem;
    List<Item> products = new ArrayList<>();
    
    public VmDaoStubImpl(){
        onlyItem = new Item("Candy", 100, 1);
        
        products.add(onlyItem);
    }

    @Override
    public List<Item> getProducts() throws VmPersistenceException {
        return products;
    }

    @Override
    public void saveItem(Item selectItem) throws VmPersistenceException {
        //do nothing...
    }
    
}
