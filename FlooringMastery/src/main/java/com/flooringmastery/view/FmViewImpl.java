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
import java.math.RoundingMode;
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
        io.readString("Order added. Please press enter to continue");
    }

    @Override
    public void displayEditBanner() {
        io.print("-~- edit Order -~-");
    }

    @Override
    public void displayEditSuccessBanner() {
        io.readString("Order edited. Please press enter to continue.");
    }

    @Override
    public void displayRemoveBanner() {
        io.print("-~- Remove Order -~-");
    }

    @Override
    public void displayRemoveSuccessBanner() {
        io.readString("Order removed. Please press enter to continue.");
    }

    @Override
    public void displayErrorMessage(String message) {
        io.readString("ERROR: Please press enter to continue");
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
                displayOrder(currentOrder);
            }
        }
        io.readString("Please press enter to continue");
    }

    @Override
    public LocalDate enterDate() throws DateTimeException {
        LocalDate ld = io.readLocalDate("Please enter the date the orders were stored on (MM/dd/yyyy)");
        return ld;
    }

    @Override
    public Order getNewOrderInfo(List<TaxRate> taxList, List<Product> productList) {
        boolean keepGoing = true;
        Order currentOrder = new Order();
        LocalDate date = io.readLocalDate("Please enter date for order (MM/dd/yyyy)");
        String name = io.readString("Please enter customer name");
        while (keepGoing) {
            if (name.isEmpty()) {
                name = io.readString("Please input a name");
            } else {
                keepGoing = false;
            }
        }
        TaxRate state = getTaxRate(taxList);
        Product prod = getProduct(productList);
        keepGoing = true;
        BigDecimal area = io.readBigDecimal("Please enter the total area of flooring requested");
        while (keepGoing) {
            if (area.compareTo(BigDecimal.ZERO) <= 0) {
                area = io.readBigDecimal("Please input an actual value");
            } else {
                keepGoing = false;
            }
        }
        currentOrder.setDate(date);
        currentOrder.setCustomerName(name);
        currentOrder.setState(state.getState());
        currentOrder.setTaxRate(state.getTaxRate());
        currentOrder.setProductType(prod.getProduct());
        currentOrder.setCostSqFt(prod.getCostSqFt());
        currentOrder.setCostLaborSqFt(prod.getLaborCostSqFt());
        currentOrder.setArea(area);
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

    private TaxRate getTaxRate(List<TaxRate> taxList, String currentState) {
        TaxRate toReturn = null;
        boolean isValid = false;
        while (!isValid) {
            String userInput = io.readString("Please enter customer state (initials only) or enter to skip");
            if (userInput.isEmpty()) {
                userInput = currentState;
            }
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
        while (!isValid) {
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

    private Product getProduct(List<Product> productList, String prod) {
        Product toReturn = null;
        boolean isValid = false;
        while (!isValid) {
            String userInput = io.readString("Please enter product requested or enter to skip");
            if (userInput.isEmpty()) {
                userInput = prod;
            }
            for (Product toCheck : productList) {
                if (toCheck.getProduct().equalsIgnoreCase(userInput)) {
                    toReturn = toCheck;
                    isValid = true;
                }
            }
        }
        return toReturn;
    }

    private void displayOrder(Order currentOrder) {
        BigDecimal taxRate = currentOrder.getTaxRate().setScale(2, RoundingMode.HALF_UP);
        BigDecimal area = currentOrder.getArea().setScale(2, RoundingMode.HALF_UP);
        BigDecimal costSqFt = currentOrder.getCostSqFt().setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCostSqFt = currentOrder.getCostLaborSqFt().setScale(2, RoundingMode.HALF_UP);
        BigDecimal materialCost = currentOrder.getMaterialCost().setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCost = currentOrder.getLaborCost().setScale(2, RoundingMode.HALF_UP);
        BigDecimal tax = currentOrder.getTaxOnTotal().setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = currentOrder.getTotal().setScale(2, RoundingMode.HALF_UP);
        io.print(Integer.toString(currentOrder.getOrderNumber()) + " " + currentOrder.getCustomerName() + " " + currentOrder.getState() + " (" + taxRate + "%) " + currentOrder.getProductType() + " " + area + "ft²" + " $" + costSqFt + " $" + laborCostSqFt + " $" + materialCost + " $" + laborCost + " $" + tax + " $" + total);
    }

    @Override
    public boolean askToConfirm(Order currentOrder) {
        displayOrder(currentOrder);
        String userChoice = io.readString("Are you sure you want to continue? (y/n)");
        return !userChoice.equalsIgnoreCase("n");
    }

    //wow I wish I would make more comments
    @Override
    public int getOrderNumber(List<Order> orderList) {
        int toReturn = -1;
        boolean isValid = false;
        while (!isValid) {
            toReturn = io.readInt("Please enter the order number");
            final int dumbCopy = toReturn;
            isValid = orderList
                    .stream().anyMatch(o -> o.getOrderNumber() == dumbCopy);
        }
        return toReturn;
    }

    @Override
    public Order getEditOrderInfo(Order currentOrder, List<TaxRate> taxList, List<Product> productList) {
        //make an edited order to return
        Order editedOrder = new Order();
        //set edited order's date and order number to the current order's order 
        //number
        LocalDate date = currentOrder.getDate();
        editedOrder.setDate(date);
        int orderNum = currentOrder.getOrderNumber();
        editedOrder.setOrderNumber(orderNum);
        //if no user input edit order info = current order
        //else edit order = user input
        //get new name or enter to skip
        io.print("customer name: " + currentOrder.getCustomerName());
        String name = io.readString("Please enter new name or press enter to skip");
        if (name == null || name.isEmpty()) {
            editedOrder.setCustomerName(currentOrder.getCustomerName());
        } else {
            editedOrder.setCustomerName(name);
        }
        //get new state or enter to skip
        io.print("customer state: " + currentOrder.getState());
        io.print("state tax: " + currentOrder.getTaxRate().toString());
        TaxRate stateTax = getTaxRate(taxList, currentOrder.getState());
        editedOrder.setState(stateTax.getState());
        editedOrder.setTaxRate(stateTax.getTaxRate());

        //get product type from user
        io.print(currentOrder.getProductType());
        io.print(currentOrder.getCostSqFt().toString());
        io.print(currentOrder.getCostLaborSqFt().toString());
        Product prod = getProduct(productList, currentOrder.getProductType());
        editedOrder.setProductType(prod.getProduct());
        editedOrder.setCostSqFt(prod.getCostSqFt());
        editedOrder.setCostLaborSqFt(prod.getLaborCostSqFt());
        //get new area or enter to skip
        io.print("specified area: " + currentOrder.getArea().toString() + "ft²");
        String area = io.readString("Please enter the total area of flooring requested or press enter to skip");
        if (area.isEmpty()) {
            editedOrder.setArea(currentOrder.getArea());
        } else {
            BigDecimal areaBd = new BigDecimal(area);
            editedOrder.setArea(areaBd);
        }

        return editedOrder;
    }

    @Override
    public void displayExitMessage() {
        io.print("Goodbye.");
    }
}
