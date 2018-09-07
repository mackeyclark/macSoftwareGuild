/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine.dao;

import com.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;

/**
 *
 * @author macam
 */
public interface VendingMachineDao {
    
    /**
     * 
     * @param priceInPennies
     * @return 
     */
    BigDecimal getPrice(VendingMachineItem priceInPennies);
}