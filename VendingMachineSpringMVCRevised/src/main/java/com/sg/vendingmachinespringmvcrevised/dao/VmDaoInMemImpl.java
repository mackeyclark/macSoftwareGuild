/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcrevised.dao;

import com.sg.vendingmachinespringmvcrevised.dto.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author macam
 */

public class VmDaoInMemImpl implements VmDao {
    
    private Map<String, Item> items = new HashMap<>();

    @Override
    public List<Item> getAllProducts() {
        return new ArrayList<Item>(items.values());
    }

    @Override
    public void saveItem(Item selectItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
