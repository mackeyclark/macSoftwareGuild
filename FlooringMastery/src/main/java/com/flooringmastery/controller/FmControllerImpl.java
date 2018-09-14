/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.controller;

import com.flooringmastery.dao.FmPersistenceException;
import com.flooringmastery.dao.FmProductsDao;
import com.flooringmastery.dao.FmTaxesDao;
import com.flooringmastery.dto.Order;
import com.flooringmastery.dto.Product;
import com.flooringmastery.dto.TaxRate;
import com.flooringmastery.service.FmServiceLayer;
import com.flooringmastery.view.FmView;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author macam
 */
public class FmControllerImpl implements FmController {

    FmView view = null;
    FmServiceLayer service = null;

    public FmControllerImpl(FmView view, FmServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void run() {
        //step 1. Display menu
        boolean keepGoing = true;
        int menuSelect = 0;
        try {
            while (keepGoing) {

                menuSelect = getMenuSelection();

                switch (menuSelect) {
                    case 1:
                        listOrders();
                        break;
                    case 2:
                        crateOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (FmPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    //step 2. Show all orders
    private void listOrders() throws FmPersistenceException {
        LocalDate ld = view.enterDate();
        view.displayAllBanner();
        List<Order> orderList = service.getOrdersByDate(ld);
        view.displayOrderList(orderList);
    }

    //step 3. Add order
    private void crateOrder() throws FmPersistenceException {
        view.displayCreateBanner();
        //getting a list of all taxes and states
        List<TaxRate> taxList = service.getAllStateTaxRates();
        //getting a list of all products and prices
        List<Product> productList = service.getAllMaterialCosts();
        //pass lists into view to check if states are valid and to provide
        //prices for user desired product
        Order currentOrder = view.getNewOrderInfo(taxList, productList);
        //ask if user wants to commit order?
        if (view.askToConfirmOrder(currentOrder) == true) {
            //pass the new order into service with date to check against
            service.createOrder(currentOrder);
            view.displayCreateSuccessBanner();
        }
    }

    //step 4. edit order
    private void editOrder() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //step 5. remove an order
    private void removeOrder() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void unknownCommand() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //step 6. exit
    private void exitMessage() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
