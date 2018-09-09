/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.view;

import com.vendingmachine01.dto.Change;
import com.vendingmachine01.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author macam
 */
public class VmViewImpl implements VmView {

    UserIO io = null;

    public VmViewImpl(UserIO io) {
        this.io = io;
    }

    @Override
    public int getMoneyAsPennies() {
        int toReturn = -1;
        BigDecimal money = io.readBigDecimal("Insert money");
        money = money.multiply(new BigDecimal(100));
        toReturn = money.intValue();
        return toReturn;
    }

    @Override
    public void showChange(Change returnChange) {
        io.print(returnChange.getDollars() + " dollars");
        io.print(returnChange.getQuarters() + " quarters");
        io.print(returnChange.getDimes() + " dimes");
        io.print(returnChange.getNickles() + " nickles");
        io.print(returnChange.getPennies() + " pennies");
    }

    @Override
    public Item selectItem(List<Item> products) {
        Item toReturn = null;
        boolean isValid = false;
        while (!isValid) {
            String userSelect = io.readString("Please enter name of product you wish to vend");
            List<Item> matchingProducts = products
                    .stream()
                    .filter(i -> userSelect.equalsIgnoreCase(i.getName()))
                    .collect(Collectors.toList());
            if (matchingProducts.isEmpty()) {
                isValid = false;
                io.readString("Invalid product. Please hit enter");
            } else {
                toReturn = matchingProducts.get(0);
                isValid = true;
            }
        }
        return toReturn;
    }

    @Override
    public boolean askKeepGoing() {
        String again = io.readString("Would you like to select another product? (y/n)");
        return !again.equalsIgnoreCase("n");
    }

    @Override
    public void printProducts(List<Item> products) {
        products.forEach(i -> printItem(i));
    }

    private void printItem(Item i) {
        io.print(i.getName());
        BigDecimal p = new BigDecimal(i.getPricePennies());
        p = p.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        io.print("$" + p);
        io.print(String.valueOf(i.getInventory()) + " in stock");
    }

    @Override
    public void displayErrorMessage(String errorMsg) {
        io.print("<<<ERROR>>>");
        io.print(errorMsg);
    }

}
