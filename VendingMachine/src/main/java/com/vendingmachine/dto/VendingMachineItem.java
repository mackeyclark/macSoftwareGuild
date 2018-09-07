/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author macam
 */
public class VendingMachineItem {
    
    String name;
    int priceInPennies;
    int inventory;

    public VendingMachineItem(String name){
        this.name = name;
    }
    
    public VendingMachineItem(int priceInPennies){
        this.priceInPennies = priceInPennies;
    }
    
    public String getName() {
        return name;
    }

    public int getPriceInPennies() {
        return priceInPennies;
    }
    
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }
    
}
