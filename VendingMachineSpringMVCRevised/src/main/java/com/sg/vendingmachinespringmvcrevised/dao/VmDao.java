/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcrevised.dao;

import com.sg.vendingmachinespringmvcrevised.dto.Item;
import java.util.List;

/**
 *
 * @author macam
 */

public interface VmDao {
    
    public List<Item> getAllProducts();
    
    public void saveItem(Item selectItem);
    
}
