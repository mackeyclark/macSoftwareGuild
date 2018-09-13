/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.service;

import com.flooringmastery.dao.FmPersistenceException;
import com.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;
import com.flooringmastery.dao.FmOrdersDao;
import com.flooringmastery.dao.FmProductsDao;
import com.flooringmastery.dao.FmTaxesDao;
import com.flooringmastery.dto.Product;
import com.flooringmastery.dto.TaxRate;

/**
 *
 * @author macam
 */
public class FmServiceLayerImpl implements FmServiceLayer {

    FmOrdersDao Odao = null;
    FmTaxesDao Tdao = null;
    FmProductsDao Pdao = null;
    
    public FmServiceLayerImpl(FmOrdersDao dao, FmTaxesDao Tdao, FmProductsDao Pdao){
        this.Odao = Odao;
        this.Tdao = Tdao;
        this.Pdao = Pdao;
    }
    
    @Override
    public List<Order> getOrdersByDate(LocalDate ld) throws FmPersistenceException {
        return Odao.getOrdersByDate(ld);
    }

    @Override
    public void createOrder(Order currentOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaxRate> getAllStateTaxRates() throws FmPersistenceException {
        return Tdao.getAllStateTaxRates();
    }

    @Override
    public List<Product> getAllMaterialCosts() throws FmPersistenceException  {
        return Pdao.getAllMaterialCosts();
    }
    
}
