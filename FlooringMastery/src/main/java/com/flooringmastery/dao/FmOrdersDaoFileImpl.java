/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macam
 */
public class FmOrdersDaoFileImpl implements FmOrdersDao {

    public static final String DELIMITER = ",";

    private void writeFile(List<Order> daysOrders, LocalDate date) throws FmPersistenceException {
        //TODO
        //step 1. set file path to "Orders_ + date + .txt" (date to String?)
        //step 2. write header row
        //step 3. write order list to file
        PrintWriter writer;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String formattedDate = date.format(formatter);
        
        try {
            writer = new PrintWriter(new FileWriter("Orders_" + formattedDate + ".txt"));
        } catch (IOException e) {
            throw new FmPersistenceException("Could not save order date", e);
        }
        
        writer.println("OrderNumber" + DELIMITER + "CustomerName" + DELIMITER + "State" + DELIMITER + "TaxRate" + DELIMITER + "ProductType" + DELIMITER + "Area" + DELIMITER + "CostPerSquareFoot" + DELIMITER + "LaborCostPerSquareFoot" + DELIMITER + "MaterialCost" + DELIMITER + "LaborCost" + DELIMITER + "Tax" + DELIMITER + "Total");
        for(Order currentOrder : daysOrders){
            writer.println(currentOrder.getOrderNumber() + DELIMITER + currentOrder.getCustomerName() + DELIMITER + currentOrder.getState() + DELIMITER + currentOrder.getTaxRate() + DELIMITER + currentOrder.getProductType() + DELIMITER + currentOrder.getArea() + DELIMITER + currentOrder.getCostSqFt() + DELIMITER + currentOrder.getCostLaborSqFt() + DELIMITER + currentOrder.getMaterialCost().setScale(2, RoundingMode.HALF_UP) + DELIMITER + currentOrder.getLaborCost().setScale(2, RoundingMode.HALF_UP) + DELIMITER + currentOrder.getTaxOnTotal().setScale(2, RoundingMode.HALF_UP) + DELIMITER + currentOrder.getTotal().setScale(2, RoundingMode.HALF_UP));
            writer.flush();
        }
        
        writer.close();
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate ld) throws FmPersistenceException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String formattedLd = ld.format(formatter);
        //creating a String to look for
        String toLookFor = "Orders_" + formattedLd + ".txt";
        //creating an arrayList to store the order data in
        List<Order> orders = new ArrayList<>();

        File orderFile = new File(toLookFor);
        //look for the flie the above string matches
        if (orderFile.exists()) {
            try {
                Scanner sc = new Scanner(orderFile);
                sc.nextLine();
                while (sc.hasNext()) {
                    //going to parse the data out of the folder
                    orders.add(parseOrder(sc.nextLine(), ld));
                }
                sc.close();
            } catch (FileNotFoundException e) {
                throw new FmPersistenceException("-_- could not load order date into memory", e);
            }
        }
        return orders;
    }

    private Order parseOrder(String line, LocalDate ld) {
        //create a String[] for our pieces of data to live on
        String[] currentTokens = line.split(DELIMITER);
        //our Order Object to be returned is going to be currentOrder
        Order currentOrder = new Order();
        currentOrder.setDate(ld);
        currentOrder.setOrderNumber(Integer.parseInt(currentTokens[0]));
        currentOrder.setCustomerName(currentTokens[1]);
        currentOrder.setState(currentTokens[2]);
        currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
        currentOrder.setProductType(currentTokens[4]);
        currentOrder.setArea(new BigDecimal(currentTokens[5]));
        currentOrder.setCostSqFt(new BigDecimal(currentTokens[6]));
        currentOrder.setCostLaborSqFt(new BigDecimal(currentTokens[7]));

        return currentOrder;
    }

    @Override
    public Order createOrder(Order currentOrder) throws FmPersistenceException {
        LocalDate date = currentOrder.getDate();
        List<Order> daysOrders = getOrdersByDate(date);
        //if a file exists with the date given a list will come back with that
        //days orders
        //if no file exists with the date provided an empty list will come back
        if (daysOrders.isEmpty()) {
            //set currentOrder as first order
            currentOrder.setOrderNumber(1);
            //put currentOrder into list
            daysOrders.add(currentOrder);
            //write file with path "Orders_ + user provided date + .txt"
            writeFile(daysOrders, date);
            //(file must be made with header row)
            return currentOrder;
        } else {
            int max = daysOrders.stream().mapToInt(d -> d.getOrderNumber()).max().getAsInt() + 1;
            //set currentOrder's orderNumber to max
            currentOrder.setOrderNumber(max);
            //put currentOrder in list
            daysOrders.add(currentOrder);
            //rewrite file
            writeFile(daysOrders, date);
            return currentOrder;
        }
    }

}
