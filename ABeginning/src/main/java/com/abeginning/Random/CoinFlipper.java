/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning.Random;

import java.util.Random;

/**
 *
 * @author macam
 */
public class CoinFlipper {
    public static void main(String[] args) {
        
        Random coinFlip = new Random();
        
        boolean flip = coinFlip.nextBoolean();
        
        if(flip == true){
            System.out.println("Heads!");
            
        }else{
            System.out.println("Tails!");
        }
    }
    
}
