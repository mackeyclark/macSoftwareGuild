/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.Scanner;

import java.util.Scanner;

/**
 *
 * @author macam
 */
public class DontForgetToStoreIt {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Give me pi to at least 5 decimals: ");
        double pi = inputReader.nextDouble();
        
        System.out.println("What is the meaning to life, the universe & everything? ");
        int meaningOfLifeAndEverything = inputReader.nextInt();
        
        System.out.println("What is you favorite kind of cheese? ");
        String cheese = inputReader.next();
        
        System.out.println("Do you like the color red or blue more? ");
        String color = inputReader.next();
        
        System.out.println("Ooh, " + color + " " + cheese + " sounds delicious");
        System.out.println("The circumstances of life is " + (2 * pi * meaningOfLifeAndEverything));
    }
    
}
