/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.view;

import com.flooringmastery.dto.Order;
import com.flooringmastery.dto.Product;
import com.flooringmastery.dto.TaxRate;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author macam
 */
public interface FmView {
    
    public void displayAllBanner();
    
    public void displayCreateBanner();
    
    public void displayCreateSuccessBanner();
    
    public void displayEditBanner();
    
    public void displayEditSuccessBanner();
    
    public void displayRemoveBanner();
    
    public void displayRemoveSuccessBanner();
        
    public int printMenuAndGetSelection();
    
    public void displayOrderList(List<Order> orderList);

    public LocalDate enterDate();

    public void displayErrorMessage(String message);

    public Order getNewOrderInfo(List<TaxRate> taxList, List<Product> productList);

    public boolean askToConfirm(Order currentOrder);

    public int getOrderNumber(List<Order> orderList);

    public Order getEditOrderInfo(Order currentOrder, List<TaxRate> taxList, List<Product> productList);

}
