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
public class TriviaNight {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        int answerOne;
        int answerTwo;
        int answerThree;
        int total = 0;
        
        System.out.println("It's TRIVIA NIGHT! Are you ready?\n");
        
        System.out.println("FIRST QUESTION!");
        System.out.println("How many bits are in a byte?");
        System.out.println("1: 4     2: 8");
        System.out.println("3: 5     4: 16\n");
        
        answerOne = userInput.nextInt();
        
        System.out.print("YOUR ANSWER:" + answerOne + "\n");
        
        System.out.println("Second Question!");
        System.out.println("What is the powerhouse of the cell?");
        System.out.println("1: Mitochondria     2: Neucleus");
        System.out.println("3: Cita     4: Peroxisome\n");
        
        answerTwo = userInput.nextInt();
        
        System.out.print("YOUR ANSWER: " + answerTwo + "\n");
        
        System.out.println("FINAL QUESTION!");
        System.out.println("What is the USA's official language?");
        System.out.println("1: English     2: French");
        System.out.println("3: Italian     4: The USA has no official language");
        
        answerThree = userInput.nextInt();
        
        System.out.print("YOUR ANSWER: " + answerThree + "\n");
        
        if(answerOne == 2){
            total++;
            
        }
        
        if(answerTwo == 1){
            total++;
            
        }
        
        if(answerThree == 4){
            total++;
            
        }
        
        System.out.println("Done! You got " + total + " correct!");
    }
    
}
