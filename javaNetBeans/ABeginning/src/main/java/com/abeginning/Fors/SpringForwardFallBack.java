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
public class SpringForwardFallBack {
    
    public static void main(String[] args) {
        
        //Spring (0,10) starts at 0 and ends at 9
        System.out.println("It's spring...!");
        for (int i = 1; i < 11; i++){
            System.out.print(i + ", ");
        }
        
        //Fall starts at 10 and ends at 1
        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--){
            System.out.print(i + ", ");
        }
    }
}
