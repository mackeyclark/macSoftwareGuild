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
public class MoreBucketsMoreFun {
    public static void main(String[] args) {
        
        //DECLARE ALL THE THINGS
        //(Usually it's a good idea to declare them at the beginning of the program)
        int butterflies, beetles, bugs;
        String color, size, shape, thing;
        double number;
        
        //Now give a couple of them values
        butterflies = 2;
        beetles = 4;
        
        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies,");
        System.out.println(" but " + bugs + " bugs total.");
        
        System.out.println("Uh oh, my dog ate one.");
        //we use a posfix -- to mark the number of butterflies down by one
        butterflies--;
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
        System.out.println("Maybe I just counted wrong the first time...");
        //the number of bugs says the same because the compiler doesn't have a 
        //loop function attached. So it doesn't recount the number of bugs 
        //there are currently
    }
    
}
