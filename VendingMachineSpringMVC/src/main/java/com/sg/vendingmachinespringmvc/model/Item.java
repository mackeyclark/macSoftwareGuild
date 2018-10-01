/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.util.Objects;

/**
 *
 * @author macam
 */
public class Item {
    
    String name;
    int pricePennies;
    int inventory;

    
    public Item(String name, int pricePennies, int inventory){
        this.name = name;
        this.pricePennies = pricePennies;
        this.inventory = inventory;
    }
    
    public String getName() {
        return name;
    }


    public int getPricePennies() {
        return pricePennies;
    }


    public int getInventory() {
        return inventory;
    }

    public void setInventory(int i) {
        this.inventory = i;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + this.pricePennies;
        hash = 23 * hash + this.inventory;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.pricePennies != other.pricePennies) {
            return false;
        }
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Item: " + name + "|price: " + pricePennies + "|inv: " + inventory;
    }
    
}
