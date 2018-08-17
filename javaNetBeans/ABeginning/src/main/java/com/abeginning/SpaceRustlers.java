/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

/**
 *
 * @author macam
 */
public class SpaceRustlers {
    public static void main(String[] args) {
        
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        if(aliens > spaceships){
            System.out.println("Vroom, vroom! Let's get going!");
            
        }else{
            System.out.println("There ain't enough green guys to drive these ships!");
            
        }
        
        if(cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers");
            
        //the if is saying that if int cows and int spaceships are the same to print out the string above
            
        }else if(cows > spaceships){
            System.out.println("Dangit! I don't know how we're going to fit all these cows in here!");
            
        //else if is telling us that if cows isn't equal to spaceships but higher to print out the above string
        
        //removing else from this else if statement doesn't seem to do anything
        
        }else{
            System.out.println("Too many ships! Not enough cows.");
            
        }
        
        if(aliens > cows){
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
            
        }else{
            System.out.println("Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!!");
            
        }
    }
    
}
