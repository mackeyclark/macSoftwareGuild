/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine.controller;

import com.vendingmachine.dao.VendingMachineDao;
import com.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.vendingmachine.ui.UserIO;
import com.vendingmachine.ui.UserIOConsoleImpl;
import com.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author macam
 */
public class VendingMachineController {
    
    VendingMachineView view = new VendingMachineView();
    VendingMachineDao dao = new VendingMachineDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing){
            io.print("1. Chocolate Bar  67¢");
            io.print("2. Potato Crisps  99¢");
            io.print("3. Bag o' Jerky   $1.20");
            io.print("4. Cancel Selection");
            
            menuSelection = io.readInt("Please select an option from the above choices.", 1, 4);
            
            switch(menuSelection){
                case 1:
                    io.print("Chocolate Bar");
                    break;
                case 2:
                    io.print("Potato Crisps");
                    break;
                case 3:
                    io.print("Bag o' Jerky");
                case 4:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("GOODBYE");
    }
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
}
