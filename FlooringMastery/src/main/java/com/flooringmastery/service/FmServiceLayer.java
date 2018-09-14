/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.service;

import com.flooringmastery.dao.FmPersistenceException;
import com.flooringmastery.dto.Order;
import com.flooringmastery.dto.Product;
import com.flooringmastery.dto.TaxRate;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author macam
 */
public interface FmServiceLayer {
    
    public List<Order> getOrdersByDate(LocalDate ld) throws FmPersistenceException;

    public Order createOrder(Order currentOrder) throws FmPersistenceException;

    public List<TaxRate> getAllStateTaxRates() throws FmPersistenceException;

    public List<Product> getAllMaterialCosts() throws FmPersistenceException;

    public Order getOrder(List<Order> orderList, int orderNum);

    public Order removeOrder(Order currentOrder) throws FmPersistenceException;

    public Order editOrder(Order currentOrder, List<TaxRate> taxList, List<Product> productList);
    
}
