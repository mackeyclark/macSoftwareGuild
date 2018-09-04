/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine.service;

/**
 *
 * @author macam
 */
public class Change {
    
    int dollars;
    int quarters;
    int dimes;
    int nickles;
    int pennies;
    
    public void change(int pennies){
        
        dollars = pennies / 100;
        pennies %= 100;
        quarters = pennies / 25;
        pennies %= 25;
        dimes = pennies / 10;
        pennies %= 10;
        nickles = pennies / 5;
        pennies %= 5;
        this.pennies = pennies;
    }
    
}
