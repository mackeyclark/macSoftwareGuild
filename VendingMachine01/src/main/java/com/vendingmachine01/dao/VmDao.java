/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.dao;

import com.vendingmachine01.dto.Item;
import java.util.List;

/**
 *
 * @author macam
 */
public interface VmDao {

    public List<Item> getProducts() throws VmPersistenceException ;

    public void saveItem(Item selectItem) throws VmPersistenceException;
    
}
