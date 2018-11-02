/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcrevised.dao;

import com.sg.vendingmachinespringmvcrevised.dto.Item;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macam
 */
@Repository
public class VmFileDaoImpl implements VmDao {

    public static final String DELIMITER = ",";

    File VmFile;

    private Map<String, Item> items = new HashMap<>();

    public VmFileDaoImpl() {
        String path = getClass()
                .getClassLoader()
                .getResource("VmItems.txt")
                .getFile();
        try {
            path = URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(VmFileDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        VmFile = new File(path);
    }

    @Override
    public List<Item> getAllProducts() {

        List<Item> toReturn = new ArrayList<>();

        try {
            FileReader fReader = new FileReader(VmFile);
            BufferedReader reader = new BufferedReader(fReader);
            Scanner sc = new Scanner(reader);

            String currentLine;
            String[] currentTokens;

            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMITER);

                Item currentItem = new Item(Integer.parseInt(currentTokens[0]), currentTokens[1], Integer.parseInt(currentTokens[2]), Integer.parseInt(currentTokens[3]));

                toReturn.add(currentItem);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VmFileDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return toReturn;
    }

    @Override
    public void saveItem(Item item) {
        items.put(item.getName(), item);
        String name = item.getName();
        WriteVm(name);
    }

    private void WriteVm(String name) {

        List<Item> itemList = this.getAllProducts();

        for (Item currentItem : itemList) {

            try {
                FileWriter writer = new FileWriter(VmFile);
                PrintWriter pWriter = new PrintWriter(writer);
                if (!currentItem.getName().equals(name)) {

                    pWriter.println(currentItem.getId() + DELIMITER + currentItem.getName() + DELIMITER + currentItem.getPrice() + DELIMITER + currentItem.getInventory());
                    pWriter.flush();

                } else {
                    int vendedItemInv = currentItem.getInventory() - 1;
                    currentItem.setInventory(vendedItemInv);
                    
                    pWriter.print(currentItem.getId() + DELIMITER + currentItem.getName() + DELIMITER + currentItem.getPrice() + DELIMITER + currentItem.getInventory());
                }
            } catch (IOException e) {

            }
            
        }

    }
}
