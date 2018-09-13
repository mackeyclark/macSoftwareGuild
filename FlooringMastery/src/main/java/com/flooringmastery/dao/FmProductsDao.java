/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Product;
import java.util.List;

/**
 *
 * @author macam
 */
public interface FmProductsDao {

    public List<Product> getAllMaterialCosts();
    
    //set up function that looks at "Products.txt" and gets cost and labor cost
    //for provided String
    
}
