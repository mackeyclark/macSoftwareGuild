/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author macam
 */
import java.util.Scanner;

public class ConsoleCalculator {
    public static void main (String[] args) {
        Scanner Scanner = new Scanner(System.in);
        
        int firstnumber = Scanner.nextInt();
        int secondnumber = Scanner.nextInt();
        String operation = Scanner.next();
        
        switch (operation) {
            case "*":
                System.out.println(firstnumber * secondnumber);
                break;
            case "/":
                System.out.println(firstnumber / secondnumber);
                break;
            case "+":
                System.out.println(firstnumber + secondnumber);
                break;
            case "-":
                System.out.println(firstnumber - secondnumber);
            
        }
    }
}
