/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine.dao;

import com.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author macam
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao{
    
    private Map<String, VendingMachineItem> items = new HashMap<>();
    
    VendingMachineItem chocolateBar = new VendingMachineItem("Chocolate Bar");
    VendingMachineItem potatoCrisps = new VendingMachineItem("Potato Crisps");
    VendingMachineItem bagJerky = new VendingMachineItem("Bag o' Jerky");
    
    @Override
    public VendingMachineItem getPrice(BigDecimal priceInPennies) {
        return items.get(priceInPennies);
    }
}
