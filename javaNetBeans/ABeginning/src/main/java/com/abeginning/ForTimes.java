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
public class ForTimes {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Which times table shall I recite? ");
        int multiplier = input.nextInt();
        
        for(int base = 1; base < 16;base++){
            System.out.println(base + " * " + multiplier + " is: " + (base * multiplier));
            
        }
    }
    
}
