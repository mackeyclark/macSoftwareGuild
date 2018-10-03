/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macam
 */
@Repository
public class VmDaoInMemImpl implements VmDao {

    public static final String VM_FILE = "vm.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Item> products = new HashMap<>();

    private void loadVm() throws VmPersistenceException {
        Scanner scanner;
        try {
            // Create scanner to read the file
            scanner = new Scanner(new BufferedReader(new FileReader(VM_FILE)));
        } catch (FileNotFoundException e) {
            throw new VmPersistenceException("-_- Could not load File data into memory.", e);
        }

        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each part of the parts of the currentLine after
        // it has been split by our DELIMITER.
        // NOTE: our DELIMITER is "::" so if currentLine looks like:
        // Candy^^500^^999
        // our tokens will be in a String array that looks like
        // ┌───────┬─────┬─────�?
        // │       │     │     │
        // │ Candy │ 500 │ 999 │
        // │       │     │     │
        // └───────┴─────┴─────┘
        //    [0]    [1]   [2]
        String[] currentTokens;
        // Go through VM_FILE line by line decoding each line into an Item 
        // object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(Pattern.quote(DELIMITER));
            // create a new Item object and put it into a map of products
            Item currentItem = new Item(currentTokens[0], Integer.parseInt(currentTokens[1]), Integer.parseInt(currentTokens[2]));

            // put currentItem into the Map using Item name as the key
            products.put(currentItem.getName(), currentItem);
        }
        // close scanner
        scanner.close();
    }

    @Override
    public List<Item> getProducts() throws VmPersistenceException {
        loadVm();
        return new ArrayList<Item>(products.values());
    }

    @Override
    public void saveItem(Item selectItem) throws VmPersistenceException {
        products.put(selectItem.getName(), selectItem);
        writeVm();
    }

    private void writeVm() throws VmPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(VM_FILE));
        } catch (IOException e) {
            throw new VmPersistenceException("could not save Item data.", e);
        }
        //write out the item object to the file
        List<Item> products = this.getProducts();
        for(Item currentItem : products){
            out.println(currentItem.getName() + DELIMITER + currentItem.getPricePennies() + DELIMITER + currentItem.getInventory());
            out.flush();
        }
        out.close();
    }

}
