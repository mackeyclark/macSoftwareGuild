/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.TaxRate;
import java.util.List;

/**
 *
 * @author macam
 */
public interface FmTaxesDao {

    public List<TaxRate> getAllStateTaxRates();
    
    //Set up a function that looks at "Taxes.txt" and retrives the tax for provided state
    
}
