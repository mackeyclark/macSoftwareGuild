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
public class InABucket {
    public static void main(String[] args) {
        
        //you cna declare all KINDS of variables.
        String walrus;
        double piesEaten;
        float weightOfTeacupPig;
        int grainsOfSand;
        
        //But declaring them just sets up the space for data
        //to use the variable, you have to put IN it first
        
        walrus= "Sir Leroy Jenkins III";
        piesEaten = 42.1;
        weightOfTeacupPig = 7.84f;
        grainsOfSand = 72955;
        
        System.out.println("Meet my pet Walrus," + walrus);
        System.out.println("He was a bit hungry today, and ate this many pies:");
        System.out.println(piesEaten);
    }
    
}
