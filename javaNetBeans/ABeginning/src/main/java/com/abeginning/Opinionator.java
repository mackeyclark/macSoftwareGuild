/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

import java.util.Random;

/**
 *
 * @author macam
 */
public class Opinionator {
    
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        System.out.println("I can't decide what animals are best");
        System.out.println("I know! Random can decide FOR ME!");
        
        //you won't get the final result because 
        //the rng is only specified from 0 - 4
        //to change this we will put the terminator at 6
        int x = randomizer.nextInt(6);
        
        System.out.println("The number we chose was " + x);
        
        if(x == 0){
            System.out.println("Dogs are the best");
            
        }else if(x == 1){
            System.out.println("Yeah no, dogs are the best");
            
        }else if(x == 2){
            System.out.println("Um, excuse me there are only dogs!");
            
        }else if(x == 3){
            System.out.println("Doggos");
            
        }else if(x == 4){
            System.out.println("ONLY DOGS ARE THE BEST");
            
        }else if(x == 5){
            System.out.println("Cats");
            
        }
        
        System.out.println("Thanks random you're the best!");
    }
    
}
