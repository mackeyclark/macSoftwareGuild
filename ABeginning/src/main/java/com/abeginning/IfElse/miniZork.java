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
public class miniZork {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("with a boarded up front door.");
        System.out.println("There is a small mail box here.");
        System.out.print("Go to the house or open the mailbox? ");
        String action = userInput.nextLine();
        
        if(action.equalsIgnoreCase("open the mailbox")){
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark inside.");
            System.out.print("look inside or stick your hand in? ");
            action = userInput.nextLine();
            
            if(action.equalsIgnoreCase("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So... so very dark.");
                System.out.print("run away or keep looking? ");
                action = userInput.nextLine();
                        
                        if(action.equalsIgnoreCase("keep looking")){
                            System.out.println("Turns out hanging around dark places isn't a good idea.");
                            System.out.println("You've been eaten by a Grue.");
                            
                        }else if(action.equalsIgnoreCase("run away")){
                            System.out.println("You run screaming across the fields - looking very foolish");
                            System.out.println("But you are alive. Possibly a wise choice.");
                            
                        }
                        
            }else if(action.equalsIgnoreCase("stick your hand in")){
                System.out.println("You reach inside and find a key.");
                System.out.println("The key doesn't seem to fit the door to the house.");
                System.out.print("keep the key or put it back? ");
                action = userInput.nextLine();
                
                if(action.equalsIgnoreCase("keep the key")){
                    System.out.println("you put the key in your pocket and turn around");
                    System.out.println("in front of you is a very unhappy looking beast");
                    System.out.println("it seems that you have taken something that doesn't belong to you");
                    System.out.print("give the key back or keep the key? ");
                    action = userInput.nextLine();
                    
                    if(action.equalsIgnoreCase("give the key back")){
                        System.out.println("good idea, that wasn't yours anyway!");
                        System.out.println("the Grue leaves you be");
                        
                    }else if(action.equalsIgnoreCase("keep the key")) {
                        System.out.println("the key to succesful negotiations is to not be beligerent");
                        System.out.println("you have been eaten by a grue");
                        
                    }
                    
                }else if(action.equalsIgnoreCase("put it back")){
                    System.out.println("good idea. Don't take things thaat aren't yours");
                    System.out.println("you turn a round and see a very pleased looking beast");
                    System.out.println("it seems that key was theirs, they offer a claw to shake");
                    System.out.print("shake their claw or run away? ");
                    action = userInput.nextLine();
                    
                    if(action.equalsIgnoreCase("shake their claw")) {
                        System.out.println("Grues are tricky creatures");
                        System.out.println("You have been eaten by a grue");
                        
                    }else if(action.equalsIgnoreCase("run away")){
                        System.out.println("you run screaming across the fields - looking very foolish");
                        System.out.println("but you are alive. Possibly a wise choice");
                    }
                }
            }
            
        }else if(action.equalsIgnoreCase("go to the house")){
            System.out.println("the house seems very dark");
            System.out.println("So... so very dark");
            System.out.println("you are likely to be eaten by a grue");
            System.out.print("run away or fight the grue? ");
            action = userInput.nextLine();
            
            if(action.equalsIgnoreCase("run away")){
                System.out.println("you run screaming across the fields - looking very foolish");
                System.out.println("but you are alive. Possibly a wise choice");
                
            }else if(action.equalsIgnoreCase("fight the grue")){
                System.out.println("grues are formidable foes");
                System.out.println("you have been eaten by a grue");
                
            }
        }
    }
}

    

