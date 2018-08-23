/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.windowmaster;

import java.util.Scanner;

/**
 *
 * @author macam
 */
public class windowMaster {
    
    public static void main(String[] args) {
        //declare variables for height and width
        float height;
        float width;

        //declare other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        //declare and intialize our scanner variable
        Scanner sc = new Scanner(System.in);

        //get input from user
        height = readValue("Please enter window height: ");
        width = readValue("Please enter window width: ");
        
        //calculate area of window
        areaOfWindow = height * width;
        
        //calculate perimeter of window
        perimeterOfWindow = 2 * (height + width);
        
        //calculate cost of window
        cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
        
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Cost of repairs = " + cost);
        
    }
    
    public static float readValue(String prompt) {
        //declare and initilize a scanner variable
        Scanner sc = new Scanner(System.in);
        //print primpt to console
        System.out.println(prompt);
        //read value into string data type
        String input = sc.nextLine();
        //convert value to float
        float floatVal= Float.parseFloat(input);
        //return the float value
        return floatVal;
    }
}
