/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.Random;

import java.util.Random;

/**
 *
 * @author macam
 */
public class ALittleChaos {
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        
        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());
        
        int num = randomizer.nextInt(100);
        
        System.out.println("You can store a random result: " + num);
        System.out.println("and use it over, and over again: " + num + ", " + num);
        
        System.out.println("Or just keep generating new values, ");
        System.out.println("here's a bunch of numbers from 0 - 100: ");
        
        //changing 101 to 50 + 50 keeps the value above 50 but below 99
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50);
    }
    
}
