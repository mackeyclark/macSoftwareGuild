/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Order;
import com.flooringmastery.view.FmView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class FmDaoFileImpl implements FmDao {
    
    FmView view = null;
    
    public FmDaoFileImpl(FmView view) {
        this.view = view;
    }
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
    LocalDate ld = LocalDate.parse(view.enterDate().toString(), formatter);
    String formattedLd = ld.format(formatter);
    
    public final String ORDER_FILE = "Order_" + formattedLd + ".txt";
    public static final String DELIMITER = ",";
    
    private Map<LocalDate, Order> orders = new HashMap<>();
    
    @Override
    public List<Order> getOrdersByDate(LocalDate date) throws FmPersistenceException {
        loadOrder();
        return new ArrayList<Order>(orders.values());
    }

    private void loadOrder() throws FmPersistenceException {
        Scanner sc;
        
        try{
            sc = new Scanner(new BufferedReader(new FileReader(ORDER_FILE)));
        }catch (FileNotFoundException e){
            throw new FmPersistenceException("-_- could not load order date into memory", e);
        }
    }
    
}
