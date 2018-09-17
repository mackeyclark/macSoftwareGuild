/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.controller;

import com.flooringmastery.dao.FmPersistenceException;
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
        if (view.askToConfirm(currentOrder) == true) {
            //pass the new order into service with date to check against
            service.createOrder(currentOrder);
            view.displayCreateSuccessBanner();
        }
    }

    //step 4. edit order
    private void editOrder() throws FmPersistenceException {
        view.displayEditBanner();
        //ask user for date order occurs on
        LocalDate ld = view.enterDate();
        List<Order> orderList = service.getOrdersByDate(ld);
        view.displayOrderList(orderList);
        if (!orderList.isEmpty()) {
            //ask user for the order's number
            int orderNum = view.getOrderNumber(orderList);
            //get specified order
            Order currentOrder = service.getOrder(orderList, orderNum);
            List<TaxRate> taxList = service.getAllStateTaxRates();
            List<Product> productList = service.getAllMaterialCosts();
            //show each piece of data to the user, prompt user to enter new data
            //user will be making a new order where the set values either equal the
            //old data or the new data the user just put in
            Order editOrder = view.getEditOrderInfo(currentOrder, taxList, productList);
            service.removeOrder(currentOrder);
            service.editOrder(editOrder);
            view.displayEditSuccessBanner();
        } else {
            view.displayErrorMessage("Could not retrive orders for date");
        }
    }

    //step 5. remove an order
    private void removeOrder() throws FmPersistenceException {
        view.displayRemoveBanner();
        //ask user for date order occurs on
        LocalDate ld = view.enterDate();
        List<Order> orderList = service.getOrdersByDate(ld);
        //ask user for the order's number
        view.displayOrderList(orderList);
        if (!orderList.isEmpty()) {
            int orderNum = view.getOrderNumber(orderList);
            Order currentOrder = service.getOrder(orderList, orderNum);
            //display order
            //ask if user wants to delete this order
            if (view.askToConfirm(currentOrder) == true) {
                //if yes, write new file without order specified
                service.removeOrder(currentOrder);
                view.displayRemoveSuccessBanner();
            }
        } else {
            view.displayErrorMessage("Could not retrive orders for date");
        }
    }

    private void unknownCommand() {
        view.displayErrorMessage("Unknown command, please press enter to continue.");
    }

    //step 6. exit
    private void exitMessage() {
        view.displayExitMessage();
    }
}
