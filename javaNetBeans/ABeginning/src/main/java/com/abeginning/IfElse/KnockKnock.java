/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.IfElse;

import java.util.Scanner;

/**
 *
 * @author macam
 */
public class KnockKnock {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("Knock! Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();
        
        if(nameGuess.equalsIgnoreCase("Marty McFly")){
            //using == in place of .equals makes the string uncomparable, but why?
            
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); //Sorry, had to!
            
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}
