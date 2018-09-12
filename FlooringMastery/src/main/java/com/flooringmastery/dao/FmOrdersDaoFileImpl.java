/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Order;
import java.io.File;
import java.io.FileNotFoundException;
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

    public FmOrdersDaoFileImpl() {
    }

    public static final String DELIMITER = ",";

    @Override
    public List<Order> getOrdersByDate(LocalDate ld) throws FmPersistenceException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String formattedLd = ld.format(formatter);

        String toLookFor = "Orders_" + formattedLd + ".txt";

        List<Order> orders = new ArrayList<>();

        File orderFile = new File(toLookFor);
        if (orderFile.exists()) {
            try {
                Scanner sc = new Scanner(orderFile);
                sc.nextLine();
                while (sc.hasNext()) { //how do I skip fist line?
                    orders.add(parseOrder(sc.nextLine(), ld));
                    //String array and convert to object?
                }
                sc.close();
            } catch (FileNotFoundException e) {
                throw new FmPersistenceException("-_- could not load order date into memory", e);
            }
        }
        return orders;
    }

    private Order parseOrder(String line, LocalDate ld) {

        String[] currentTokens = line.split(DELIMITER);
        Order currentOrder = new Order();
        currentOrder.getOrderNumber(currentTokens[0]);
        currentOrder.getCustomerName(currentTokens[1]);
        currentOrder.getState(currentTokens[2]);
        currentOrder.getTaxRate(currentTokens[3]);
        currentOrder.getProductType(currentTokens[4]);
        currentOrder.getArea(currentTokens[5]);
        currentOrder.getCostSqFt(currentTokens[6]);
        
    }

}
