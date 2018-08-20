/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthyhearts;

import java.util.Scanner;

/**
 *
 * @author macam
 */
public class HealthyHearts {
    
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Please enter your age: ");
        double userAge = userInput.nextInt();
        
        double ageMax = 220 - userAge;
        
        System.out.println("Your heart rate should be " + ageMax + "bpm");
        System.out.println("Your target range should be between " + (.5 * ageMax) + " and " + (.85 * ageMax) + " bpm");
    }
    
}
