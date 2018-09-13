/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery.dao;

import com.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class FmProductsDaoFileImpl implements FmProductsDao {
    
    public static final String PROD_FILE = "Products.txt";
    public static final String DELIMITER = ",";
    
    private Map<String, Product> prodMap = new HashMap<>();
    
        private void loadFile() throws FmPersistenceException {
        Scanner sc;

        try {
            //scanner will read our provided TAXES_FILE
            sc = new Scanner(new BufferedReader(new FileReader(PROD_FILE)));
        } catch (FileNotFoundException e) {
            //if scanner can't find the suggested file it will throw this error
            throw new FmPersistenceException("-_- Could not load File data into memory.", e);
        }

        //we want to skip the header row
        sc.nextLine();
        String line;
        String[] tokens;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            tokens = line.split(DELIMITER);
            Product prod = new Product();
            prod.setProduct(tokens[0]);
            prod.setCostSqFt(new BigDecimal(tokens[1]));
            prod.setLaborCostSqFt(new BigDecimal(tokens[2]));

            prodMap.put(prod.getProduct(), prod);
        }
        sc.close();
    }


    @Override
    public List<Product> getAllMaterialCosts() throws FmPersistenceException {
        loadFile();
        return new ArrayList<Product>(prodMap.values());
    }
    
}
