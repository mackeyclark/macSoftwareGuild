/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.WhilesAndDos;

import java.util.Scanner;

/**
 *
 * @author macam
 */
public class DoOrDoNot {
    
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Should I do it? (y/n) ");
        boolean doIt;
        
        if(userInput.next().equals("y")){
            doIt = true; // Execute order 66
            
        }else{
            doIt = false; // DONT YOU DARE!
            
        }
        
        boolean iDidIt = false;
        
        /*do {
            iDidIt = true;
            break;
            
        } while (doIt);*/
        
        while (doIt){
            iDidIt = true;
            break;
        }
        
        if(doIt && iDidIt){
            System.out.println("I did it!");
            
        }else if(!doIt && iDidIt){
            System.out.println("I know you said not to... but I totally did it anyways.");
            
        }else{
            System.out.println("Don't look at me, I didn't do anything!");
        }
        //doIt = y   I did it!
        //doIt = n   I did it anyway :T
        
        //with while loop
        //doIt = y I did it!
        //doIt = n I did nothing
    }
    
}
