/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class RockPaperScissors {
    
    public static void main(String[] args) {
        
        String playAgain;
        Scanner userInput = new Scanner(System.in);
        
        do{
            roShamBo();
            System.out.print("Woud you like to play again? (y/n) ");
            playAgain = userInput.next();
            
        }while(playAgain.equalsIgnoreCase("y"));
        System.out.println("Thanks for playing!");
        
    }
        
        public static void roShamBo(){
        
        Scanner userInput = new Scanner(System.in);
        Random randomNumber = new Random();
        
        final int rock = 1;
        final int paper = 2;
        final int scissors = 3;
        
        int userWins = 0;
        int cPUWins = 0;
        
        System.out.print("How many games of Ro-Sham-Bo do you want to play? ");
        int roundsDesired = userInput.nextInt();
        
        if(roundsDesired <= 10 && roundsDesired >=0){
            
        for(int i = 0; i < roundsDesired; i++) {
        
        System.out.print("Rock(1)! Paper(2)! Scissors(3)! Shoot! ");
        int userHand = userInput.nextInt();
        
        int randomHand = randomNumber.nextInt(3) + 1;
        
            if(userHand == randomHand){
                System.out.println("Its a tie!");
            }
        
            if(randomHand == rock){
                
                if(userHand == scissors){
                    System.out.println("You lose this round!");
                    cPUWins++;
                
                }else if(userHand == paper){
                    System.out.println("You win this time!");
                    userWins++;
                
                }
            }
        
            if(randomHand == paper){
                
                if(userHand == rock){
                    System.out.println("You lose this round!");
                    cPUWins++;
                
                }else if(userHand == scissors){
                    System.out.println("You win this time!");
                    userWins++;
                
                }
            }
        
            if(randomHand == scissors){
                
                if(userHand == paper){
                    System.out.println("You lose this round!");
                    cPUWins++;
                
                }else if(userHand == rock){
                    System.out.println("You win this time!");
                    userWins++;
                
                }
            }
        }
        
           if(userWins == cPUWins){
                System.out.println("Draw game :T");
            
            }
            if(userWins < cPUWins){
                System.out.println("I've won this game!");
            
            }
            if(userWins > cPUWins){
                System.out.println("How could I lose to you?");
            
            }
        
        }else{
            System.out.println("I don't wanna play that many games!");
        }
        
        
    
    }
}
