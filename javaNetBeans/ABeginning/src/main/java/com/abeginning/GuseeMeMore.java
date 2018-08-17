/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class GuseeMeMore {
    public static void main(String[] args) {
        
                Scanner userInt = new Scanner(System.in);
                Random randomNum = new Random();
        
        int numberPicked = randomNum.nextInt(100 + 1 + 100) - 100;
        String userGuess;
        int userNumber;
        
        System.out.println("I've chosen a number. Bet you can't guess it");
        userGuess = userInt.nextLine();
        
        userNumber = Integer.parseInt(userGuess);
        
        System.out.println("Your guess: " + userNumber);
        
        if(userNumber == numberPicked){
            System.out.println("Uh wow, yeah, you got it.");
            
        }else if(userNumber > numberPicked){
            System.out.print("Ah, too high, try again.");
            userGuess = userInt.nextLine();
            
        }else{
            System.out.print("Ah, too low, try again.");
            userGuess = userInt.nextLine();
        
        /*else if(userNumber > numberPicked){
            System.out.println("Ha! Too high, I picked " + numberPicked + "! you owe me $20!");
            
        } else{
            System.out.println("Sorry, too low, I picked " + numberPicked + "! you owe me $20!");*/
            
        }
    }
    
}

