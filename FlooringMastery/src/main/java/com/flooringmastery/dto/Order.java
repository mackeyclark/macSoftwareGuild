/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author macam
 */
public class Order {
    
    LocalDate date;
    int orderNumber;
    String customerName;
    String state;
    BigDecimal taxRate;
    String productType;
    BigDecimal area;
    BigDecimal costSqFt;
    BigDecimal costLaborSqFt;

    public LocalDate getDate() {
        return date;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getTaxRate() {
        return taxRate; //should this come from the dto for TaxRate?
    }

    public String getProductType() {
        return productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public BigDecimal getCostSqFt() {
        return costSqFt;
    }

    public BigDecimal getCostLaborSqFt() {
        return costLaborSqFt;
    }
    
    public BigDecimal getMaterialCost() {
        return area.multiply(costSqFt).setScale(2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getLaborCost() {
        return area.multiply(costLaborSqFt).setScale(2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getTaxOnTotal() {
        BigDecimal total = getMaterialCost().add(getLaborCost());
        BigDecimal taxPerc = taxRate.divide(BigDecimal.valueOf(100));
        BigDecimal tax = total.multiply(taxPerc).setScale(2, RoundingMode.HALF_UP);
        return tax;
    }
    
    public BigDecimal getTotal() {
        BigDecimal totalAndTax = getMaterialCost().add(getLaborCost()).add(getTaxOnTotal().setScale(2, RoundingMode.HALF_UP));
        return totalAndTax;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public void setCostSqFt(BigDecimal costSqFt) {
        this.costSqFt = costSqFt;
    }

    public void setCostLaborSqFt(BigDecimal costLaborSqFt) {
        this.costLaborSqFt = costLaborSqFt;
    }
    
}
