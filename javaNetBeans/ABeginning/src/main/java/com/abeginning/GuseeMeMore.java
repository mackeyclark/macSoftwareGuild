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
        
        while(userNumber < numberPicked){
            System.out.print("Nope - too low. Try again: ");
            userGuess = userInt.nextLine();
        
            userNumber = Integer.parseInt(userGuess);
            
        }
        
        while(userNumber > numberPicked){
            System.out.print("Nope - too high. Try again: ");
            userGuess = userInt.nextLine();
        
            userNumber = Integer.parseInt(userGuess);
        }
        
                if(userNumber == numberPicked){
            System.out.println("Uh wow, yeah, you got it.");
            
        }
    }
    
}

