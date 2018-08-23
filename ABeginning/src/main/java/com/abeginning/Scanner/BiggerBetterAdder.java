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
public class BiggerBetterAdder {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Give me a number: ");
        double numberOne = userInput.nextDouble();
        
        System.out.println("Give me another number: ");
        double numberTwo = userInput.nextDouble();
        
        System.out.println("Give me one last number: ");
        double numberThree = userInput.nextDouble();
        
        System.out.println("Number 1 is: " + numberOne);
        System.out.println("Number 2 is: " + numberTwo);
        System.out.println("Number 3 is: " + numberThree);
        
        double sum = numberOne + numberTwo + numberThree;
        
        System.out.println("The sum of " + numberOne + ", " + numberTwo + ", & " + numberThree + " is " + sum);
    }
    
}
