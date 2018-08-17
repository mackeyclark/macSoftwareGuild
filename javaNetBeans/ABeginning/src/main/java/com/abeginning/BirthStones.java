/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

import java.util.Scanner;

/**
 *
 * @author macam
 */
public class BirthStones {
    public static void main(String[] args){
        
        Scanner userInput = new Scanner(System.in);
        
        int userMonthBorn;
        
        System.out.print("What month were you born? (Valid input XX) ");
        userMonthBorn = userInput.nextInt();
        
        if(userMonthBorn == 1){
            System.out.println("January's birthstone is Garnet");
            
        }else if(userMonthBorn == 2){
            System.out.println("Febuary's birthstone is Amethyst");
            
        }else if(userMonthBorn == 3){
            System.out.println("March's birthstone is Aquamarine");
            
        }else if(userMonthBorn == 4){
            System.out.println("April's birthstone is Diamond");
            
        }else if(userMonthBorn == 5){
            System.out.println("May's birthstone is Emerald");
            
        }else if(userMonthBorn == 6){
            System.out.println("June's birthstone is Pearl");
            
        }else if(userMonthBorn == 7){
            System.out.println("July's birthstone is Ruby");
            
        }else if(userMonthBorn == 8){
            System.out.println("August's birthstone is Peridot");
            
        }else if(userMonthBorn == 9){
            System.out.println("September's birthstone is Sapphire");
            
        }else if(userMonthBorn == 10){
            System.out.println("October's birthsone is Opal");
            
        }else if(userMonthBorn == 11){
            System.out.println("November's birthstone is Topaz");
            
        }else if(userMonthBorn == 12){
            System.out.println("December's birthstone is Turquoise");
            
        }else{
            System.out.println("Sweetie, play along. " + userMonthBorn + " isn't valid, something between 1 and 12 please.");
        }
    }
    
}
