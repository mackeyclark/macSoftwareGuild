/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import java.io.FileNotFoundException;

/**
 *
 * @author macam
 */
public class FmPersistenceException extends Exception {

    public FmPersistenceException(String message) {
        super(message);
    }
    
    public FmPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
    
}
