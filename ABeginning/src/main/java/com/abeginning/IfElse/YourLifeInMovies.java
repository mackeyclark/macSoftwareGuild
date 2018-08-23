/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.IfElse;

import java.util.Scanner;

/**
 *
 * @author macam
 */
public class YourLifeInMovies {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        String userName;
        int userAge;
        
        System.out.print("Lets play a game. What's your name honey? ");
        userName = userInput.nextLine();
        
        System.out.print("Alright, " + userName + ", what year were you born?");
        userAge = userInput.nextInt();
        
        if(userAge <= 2005){
            System.out.println("Did you know that Pixar's \"Up\" came out half-a-decade ago?");
            
        }
        
        if(userAge <= 1995){
            System.out.println("And the First \"Harry Potter\" came out over 15 years ago!");
            
        }
        if(userAge <= 1985){
            System.out.println("Also, \"Space Jam\" came out not last decade, but the one before THAT.");
            
        }
        if(userAge <= 1975){
            System.out.println("You, like the original \"Jurassic Park\", are closer to the date of the first lunar landing than to today!");
            
        }
        if(userAge <= 1965){
            System.out.println("One more thing, the TV series \"MASH\" has been around for almost half a century!");
        }
    }
    
}
