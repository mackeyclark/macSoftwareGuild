/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine;

import com.vendingmachine.controller.VendingMachineController;

/**
 *
 * @author macam
 */
public class App {
    
    public static void main(String[] args) {
        VendingMachineController controller = new VendingMachineController();
        controller.run();
    }
    
}
