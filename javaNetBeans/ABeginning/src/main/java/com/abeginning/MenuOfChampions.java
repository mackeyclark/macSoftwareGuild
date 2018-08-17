/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

/**
 *
 * @author macam
 */
public class MenuOfChampions {
    public static void main(String[] args) {
        
        String menuItemOne = "Dim Sum";
        String menuItemTwo = "Wontons";
        String menuItemThree = "Hot and Sour soup";
        double priceOne = 9.99;
        double priceTwo = 7.79;
        double priceThree = 11.49;
        
        System.out.println("     .-.     .-.     .-.     .-.     .-.     .-.     .-.");
        System.out.println("`._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'");
        
        System.out.println("              WELCOME TO LITTLE HOLLY'S                 ");
        System.out.println("                  Today's menu is...                    ");
        
        System.out.println("     .-.     .-.     .-.     .-.     .-.     .-.     .-.");
        System.out.println("`._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'");
        
        System.out.print(menuItemOne);
        System.out.println("           $   " + priceOne);
        
        System.out.print(menuItemTwo);
        System.out.println("           $   " + priceTwo);
        
        System.out.print(menuItemThree);
        System.out.println(" $   " + priceThree);
    }
}
