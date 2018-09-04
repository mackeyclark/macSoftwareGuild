/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine.ui;

import java.math.BigDecimal;

/**
 *
 * @author macam
 */
public class VendingMachineView {
    
    UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection(){
        io.print("Snack-a-tronic");
        io.print("Select option");
        io.print("1. Chocolate Bar");
        io.print("2. Potato Crisps");
        io.print("3. Bag o' Jerky");
        io.print("4. Cancel Selection");
        
        return io.readInt("Please select from the following options", 1, 4);
        
    }
    
    public BigDecimal askAndGetMoney(){
        BigDecimal money = io.readBigDecimal("Please insert amount due");
        BigDecimal pennies = money.setScale(2);
        return pennies;
    }
}
