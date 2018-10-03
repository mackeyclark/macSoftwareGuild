/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.controller.InsufficentFundsException;
import com.sg.vendingmachinespringmvc.controller.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.dao.VmDao;
import com.sg.vendingmachinespringmvc.dao.VmPersistenceException;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author macam
 */
@Service
public class VmServiceImpl implements VmService {

    VmDao dao = null;

    public VmServiceImpl(VmDao dao) {
        this.dao = dao;

    }


    @Override
    public Change vend(int moneyAsPennies, Item selectItem) throws InsufficentFundsException, NoItemInventoryException, VmPersistenceException{
        if(selectItem == null){          
            throw new IllegalArgumentException();
        }
        
        if(selectItem.getInventory() == 0){
//            auditDao.writeAuditEntry("NoItemInventoryException THROWN");
            throw new NoItemInventoryException("Out of stock");
        }
        
        if(moneyAsPennies < selectItem.getPricePennies()){
//            auditDao.writeAuditEntry("InsufficentFundsException THROWN");
            throw new InsufficentFundsException("Not enough money for selection");
        }
        
        int change = moneyAsPennies - selectItem.getPricePennies();
        Change returnChange = new Change(change);
        
        selectItem.setInventory(selectItem.getInventory() - 1);
        
        dao.saveItem(selectItem);
        return returnChange;
    }

    @Override
    public List<Item> getProducts() throws VmPersistenceException {
        return dao.getProducts();
    }

}
