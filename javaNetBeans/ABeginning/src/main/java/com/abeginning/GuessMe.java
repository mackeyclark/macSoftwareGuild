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
public class GuessMe {
    public static void main(String[] args) {
        
        Scanner userInt= new Scanner(System.in);
        
        int numberPicked = 42;
        String userGuess;
        int userNumber;
        
        System.out.println("I've chosen a number. Bet you $20 you can't guess it");
        userGuess = userInt.nextLine();
        
        userNumber = Integer.parseInt(userGuess);
        
        System.out.println("Your guess: " + userNumber);
        
        if(userNumber == numberPicked){
            System.out.println("Uh, yeah, sorry I don't have $20.");
            
        } else if(userNumber > numberPicked){
            System.out.println("Ha! Too high, you owe me $20!");
            
        } else{
            System.out.println("Sorry, too low, you owe me $20!");
            
        }
    }
    
}
