/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.view;

import com.flooringmastery.dto.Order;
import com.flooringmastery.ui.UserIO;
import com.flooringmastery.ui.UserIOConsoleImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author macam
 */
public class FmViewImpl implements FmView {
    
    UserIO io = new UserIOConsoleImpl();

    @Override
    public void displayAllBanner() {
        io.print("-~- Display All Orders -~-");
    }

    @Override
    public void displayCreateBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayCreateSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayEditBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayEditSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayRemoveBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayRemoveSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int printMenuAndGetSelection() {
        io.print("<< Flooring program >>");
        io.print("1. Display orders");
        io.print("2. Add an order");
        io.print("3. Edit an order");
        io.print("4. Remove an order");
        io.print("5. Exit");
        
        return io.readInt("Please select from the above choices", 1, 5);
    }
        
    @Override
    public void displayOrderList(List<Order> orderList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDate enterDate() {
        String userDate = io.readString("Please enter the date the orders were stored on");
        LocalDate ld = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("MMddyyyy"));
        return ld;
    }
    

}
