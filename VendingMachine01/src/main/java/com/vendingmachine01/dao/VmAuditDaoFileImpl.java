/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author macam
 */
public class VmAuditDaoFileImpl implements VmAuditDao{
    
    public static final String AUDIT_FILE = "VmAudit.txt";

    public void writeAuditEntry(String entry) throws VmPersistenceException {
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        }catch(IOException e){
            throw new VmPersistenceException("Could not audit this information", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + ": " + entry);
        out.flush();
    }
    
}
