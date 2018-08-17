/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

import java.util.Random;

/**
 *
 * @author macam
 */
public class FortuneCookie {
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        
        int fortune = randomizer.nextInt(10);
        String cookie = "";
        switch(fortune){
            case 0: cookie = "Those aren't the droids you're looking for";
            break;
            
            case 1: cookie = "Never go in against a Sicilian when death is on the line!";
            break;
            
            case 2: cookie = "Goonies never say die.";
            break;
            
            case 3: cookie = "With great power, there must also come — great responsibility.";
            break;
            
            case 4: cookie = "Never argue with the data.";
            break;
            
            case 5: cookie = "Try not. Do, or do not. There is no try.";
            break;
            
            case 6: cookie = "You are a leaf on the wind; watch how you soar.";
            break;
            
            case 7: cookie = "Do absolutely nothing, and it will be everything that you thought it could be.";
            break;
            
            case 8: cookie = "Kneel before Zod.";
            break;
            
            case 9: cookie = "Make it so.";
            break;
            
        }
        System.out.println("Your Geek Fortune: " + cookie);
    }
    
}