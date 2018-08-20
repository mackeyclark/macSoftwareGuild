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
public class RollerCoaster {
    
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("We're going to go on a roller coaster....");
        System.out.println("Let me know when you want to get off...!");
        
        String keepRiding = "y";
        int loopsLooped = 0;
        while (keepRiding.equals("y")){
        // while (keepRiding.equals("n")){ 
        // looped 0 times because the variable keep riding is iniialized with "y" 
        // while "n" is not equal to the y unicode
            System.out.println("WHEEEEEEEEEEEEEEEeEEEEeEEEEEEE...!!");
            System.out.print("Want to keep going? (y/n) : ");
            keepRiding = userInput.nextLine();
            loopsLooped++; 
        // there is no value assigned because loops because depending on whether
        // we answer yes or no the loop will connt up at loopsLooped++
            
        }
        
        System.out.println("Wow, that was fun!");
        System.out.println("we looped that loop " + loopsLooped + " times!!");
    }
    
}
