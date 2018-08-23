/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.Fors;

/**
 *
 * @author macam
 */
public class ForAndTwentyBlackbirds {
    
    public static void main(String[] args) {
        int birdsInPie = 0;
        for(int i = 1; i < 25; i++){
        //initialized i to 1 and increased the range to 25 to get the range 1 - 24
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }
        
        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }
    
}
