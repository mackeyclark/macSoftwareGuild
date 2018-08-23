/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doggenetics;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class DogGenetics {
    
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        String dogBreedArray[] = {"husky", "shepard", "collie", "corgi", "coyote"};
        
        //int percentArray[] = {initialDogBreedPercent(int) };
    }
    
    public static int initialDogBreedPercent(int rangeFloor, int rangeCieling){
        Random randomPercent = new Random();
        rangeFloor = randomPercent.nextInt(99 + 1);
        rangeCieling = 101;
        return rangeFloor;
        
    }
    
    public static int secondDogBreedPercent(int rangeFloor, int rangeCieling){
        Random randomPercent = new Random();
        //rangeFloor = randomPercent.nextInt(99 - percentArray[1] + 1) + percentArray[1];
        rangeCieling = 101;
        return rangeFloor;
        
    }
}
