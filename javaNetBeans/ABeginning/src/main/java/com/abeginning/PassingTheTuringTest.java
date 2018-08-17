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
public class PassingTheTuringTest {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        
        String yourName;
        String favoriteColor;
        String favoriteFruit;
        int favoriteInt;
        
        System.out.println("Hey!");
        System.out.print("Whats your name? ");
        yourName = inputReader.next();
        
        System.out.print("Hi " + yourName + ". What's your favorite color?");
        favoriteColor = inputReader.next();
        
        System.out.println(favoriteColor + "? That reminds me of Rome in summer!");
        
        System.out.println("I love to eat tomato salad in Rome. Did you know tomatoes are a fruit?");
        System.out.print("What's your favorit fruit?");
        favoriteFruit = inputReader.next();
        
        System.out.println("Ew, " + favoriteFruit + " sounds awful, sorry. Do you have a favorite number?");
        favoriteInt = inputReader.nextInt();
        
        System.out.println("Nice! Mine is 24. Wait, I thought of a better number, " + (24 / favoriteInt) +"! It's mine divided by yours!");
        System.out.println("Well, nice talking with you :D c'ya!");
    }
    
}
