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
public class StayPositive {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("What number should I count down from? ");
        int userNumber = userInput.nextInt();
        
        System.out.println("Here goes!");
        
        while(userNumber > 0){
            
            System.out.println(userNumber--);
            
        }
    }
    
}
