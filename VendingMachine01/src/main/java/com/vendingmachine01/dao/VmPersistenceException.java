/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.dao;

/**
 *
 * @author macam
 */
public class VmPersistenceException extends Exception {
    
    public VmPersistenceException(String message){
        super(message);
    }
    
    public VmPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
    
}
