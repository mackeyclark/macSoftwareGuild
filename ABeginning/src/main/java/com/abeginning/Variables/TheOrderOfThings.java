/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.Variables;

/**
 *
 * @author macam
 */
public class TheOrderOfThings {
    public static void main(String[] args) {
        
        double number;
        String option, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        option = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCentaurian";
        material = "platinum";
        purpose = "good";
        
        noun = "dragons";
        
        //Using the + with strings doesn't add, it concatenates! (sticks them together)
        System.out.println(number + " " + option + " "  + size + " "  + age + " "  + shape + " "  + color + " "  + origin + " "  + material + " "  + purpose + " "  + noun);
        System.out.println(shape + " "  + age + " "  + color + " "  + size + " "  + number + " "  + origin + " "  + option + " "  + purpose + " "  + material + " "  + noun);
        System.out.println(age + " "  + color + " "  + material + " "  + number + " "  + option + " "  + origin + " "  + purpose + " "  + shape + " "  + size + " "  + noun);
    }
    
}
