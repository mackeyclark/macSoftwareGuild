/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.view;

import com.vendingmachine01.dto.Change;
import com.vendingmachine01.dto.Item;
import java.util.List;

/**
 *
 * @author macam
 */
public interface VmView {

    public int getMoneyAsPennies();

    public void showChange(Change returnChange);

    public Item selectItem(List<Item> products);

    public boolean askKeepGoing();

    public void printProducts(List<Item> products);

    public void displayErrorMessage(String message);
    
}
