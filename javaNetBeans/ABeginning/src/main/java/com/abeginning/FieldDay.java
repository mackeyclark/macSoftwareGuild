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
public class FieldDay {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        String redDragons = "Baggins";
        String darkWizards = "Dresden";
        String movingCastles = "Howl";
        String goldenSniches = "Potter";
        String nightGaurds = "Vimes";
        int team;
        
        System.out.print("What's your last name? ");
        String userName = userInput.nextLine();
      
        if(userName.compareToIgnoreCase(redDragons) < 0){
            System.out.println("You belong to the Red Dragons!");
            
        }else if(userName.compareToIgnoreCase(darkWizards) < 0){
            System.out.println("You are on Dark Wizards!");
            
        }else if(userName.compareToIgnoreCase(movingCastles) < 0){
            System.out.println("You are a Moving Castle!");
            
        }else if(userName.compareToIgnoreCase(goldenSniches) < 0){
            System.out.println("Welcome to the Golden Sniches!");
            
        }else if(userName.compareToIgnoreCase(nightGaurds) < 0){
            System.out.println("One going to the Night Gaurds!");
            
        }else{
            System.out.println("You're on the Black Holes!");
            
        }
    }
}
