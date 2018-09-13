/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.view;

import com.flooringmastery.dto.Order;
import com.flooringmastery.dto.Product;
import com.flooringmastery.dto.TaxRate;
import com.flooringmastery.ui.UserIO;
import com.flooringmastery.ui.UserIOConsoleImpl;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
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
        io.print("-~- Create New Order -~-");
    }

    @Override
    public void displayCreateSuccessBanner() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayEditBanner() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayEditSuccessBanner() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayRemoveBanner() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayRemoveSuccessBanner() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayErrorMessage(String message) {
        //TODO
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
        if (orderList.isEmpty()) {
            io.readString("No Orders found for date provided. Please press enter to continue");
        } else {
            for (Order currentOrder : orderList) {
                BigDecimal taxRate = currentOrder.getTaxRate();
                BigDecimal area = currentOrder.getArea();
                BigDecimal costSqFt = currentOrder.getCostSqFt();
                BigDecimal laborCostSqFt = currentOrder.getCostLaborSqFt();
                BigDecimal materialCost = currentOrder.getMaterialCost();
                BigDecimal laborCost = currentOrder.getLaborCost();
                BigDecimal tax = currentOrder.getTaxOnTotal();
                BigDecimal total = currentOrder.getTotal();
                io.print(Integer.toString(currentOrder.getOrderNumber()) + " " + currentOrder.getCustomerName() + " " + currentOrder.getState() + " (" + taxRate + "%) " + currentOrder.getProductType() + " " + area + "ft²" + " $" + costSqFt + " $" + laborCostSqFt + " $" + materialCost + " $" + laborCost + " $" + tax + " $" + total);
            }
        }
        io.readString("Please press enter to continue");
    }

    @Override
    public LocalDate enterDate() throws DateTimeException {
        LocalDate ld = io.readLocalDate("Please enter the date the orders were stored on");
        return ld;
    }

    @Override
    public Order getNewOrderInfo(List<TaxRate> taxList, List<Product> productList) {
        String name = io.readString("Please enter customer name");
        TaxRate state = getTaxRate(taxList);
        Product prod = getProduct(productList);
        BigDecimal area = io.readBigDecimal("Please enter the total area of flooring requested");
        Order currentOrder = new Order();
        currentOrder.setCustomerName(name);
        currentOrder.setState(state.getState());
        currentOrder.setTaxRate(state.getTaxRate());
        currentOrder.setProductType(prod.getProduct());
        currentOrder.setCostSqFt(prod.getCostSqFt());
        currentOrder.setCostLaborSqFt(prod.getLaborCostSqFt());
        currentOrder.setArea(area);
        currentOrder.getMaterialCost();
        currentOrder.getLaborCost();
        currentOrder.getTaxOnTotal();
        currentOrder.getTotal();
        return currentOrder;
    }

    private TaxRate getTaxRate(List<TaxRate> taxList) {
        TaxRate toReturn = null;
        boolean isValid = false;
        while (!isValid) {
            String userInput = io.readString("Please enter customer state (initials only)");
            for (TaxRate toCheck : taxList) {
                if (toCheck.getState().equalsIgnoreCase(userInput)) {
                    toReturn = toCheck;
                    isValid = true;
                }
            }
        }
        return toReturn;
    }

    private Product getProduct(List<Product> productList) {
        Product toReturn = null;
        boolean isValid = false;
        while (!isValid){
            String userInput = io.readString("Please enter product requested");
            for (Product toCheck : productList) {
                if (toCheck.getProduct().equalsIgnoreCase(userInput)) {
                    toReturn = toCheck;
                    isValid = true;
                }
            }
        }
        return toReturn;
    }
}