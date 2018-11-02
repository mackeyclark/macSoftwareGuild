/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcrevised.service;

import com.sg.vendingmachinespringmvcrevised.dao.VmDao;
import com.sg.vendingmachinespringmvcrevised.dto.Change;
import com.sg.vendingmachinespringmvcrevised.dto.Item;
import java.util.List;

/**
 *
 * @author macam
 */
public class VmServiceImpl implements VmService {

    VmDao dao;

    public VmServiceImpl(VmDao dao) {
        this.dao = dao;
    }

    @Override
    public Change vend(int money, Item item) throws InsufficentFundsException, NoItemInventoryException {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (item.getInventory() == 0) {
            throw new NoItemInventoryException("Out of stock");
        }

        if (money < item.getPrice()) {
            throw new InsufficentFundsException("Not enough money for selection");
        }

        int change = money - item.getPrice();
        Change returnChange = new Change(change);

        item.setInventory(item.getInventory() - 1);

        dao.saveItem(item);
        return returnChange;
    }

    @Override
    public List<Item> getAllProducts() {
        return dao.getAllProducts();
    }

}
