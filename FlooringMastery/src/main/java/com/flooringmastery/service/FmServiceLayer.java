/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.service;

import com.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author macam
 */
public interface FmServiceLayer {
    
    public List<Order> getOrdersByDate(LocalDate date);
    
}
