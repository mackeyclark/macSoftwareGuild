/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class FmOrdersDaoFileImpl implements FmOrdersDao {

    public static final String DELIMITER = ",";

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

}
