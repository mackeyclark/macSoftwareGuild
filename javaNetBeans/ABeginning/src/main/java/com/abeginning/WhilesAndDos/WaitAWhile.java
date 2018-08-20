/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.WhilesAndDos;

/**
 *
 * @author macam
 */
public class WaitAWhile {
    
    public static void main(String[] args) {
        
        int timeNow = 5; // chnging value to 11 skips while loop because timeNow > bedTime
        int bedTime = 10; // Increases or decreases termination variable
        
        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll say up just a liiiiittle longer....");
            //timeNow++; INFINITE LOOP! // Time passes
        }
        
        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed....");
    }
    
}
