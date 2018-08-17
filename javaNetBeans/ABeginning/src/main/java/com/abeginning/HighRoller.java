/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class HighRoller {
    public static void main(String[] args) {
        
        Random diceRoller = new Random();
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("How many sides does your dice? ");
        int dice = userInput.nextInt();
        
        int rollResult = diceRoller.nextInt(dice) + 1;
        
        System.out.println("Time to ROOOOOOOOOOLL the dice!");
        System.out.println("I rolled a " + rollResult);
        
        if(rollResult == 1){
            System.out.println("Oof! Criical failure.");
        }
        if(rollResult == dice){
            System.out.println("Crit success!");
        }
    }
    
}
