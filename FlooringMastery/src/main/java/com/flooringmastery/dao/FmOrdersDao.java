/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author macam
 */
public interface FmOrdersDao {

    List<Order> getOrdersByDate(LocalDate ld) throws FmPersistenceException;

    public Order createOrder(Order currentOrder) throws FmPersistenceException;

    public Order getOrder(List<Order> orderList, int orderNum);

    public Order removeOrder(Order currentOrder) throws FmPersistenceException;

    public Order editOrder(Order editOrder) throws FmPersistenceException;

}
