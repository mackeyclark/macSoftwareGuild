/*
 * To Change this license header, choose License Headers in Project Properties.
 * To Change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

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
    
    public Change(int pennies){
        
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

    public int getDollars() {
        return dollars;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickles() {
        return nickles;
    }

    public int getPennies() {
        return pennies;
    }

}
