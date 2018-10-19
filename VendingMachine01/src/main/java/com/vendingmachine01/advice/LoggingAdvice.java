/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.advice;

import com.vendingmachine01.dao.VmAuditDao;
import com.vendingmachine01.dao.VmPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author macam
 */
public class LoggingAdvice {
    
    VmAuditDao auditDao;
    
    public LoggingAdvice(VmAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp, Throwable ex){
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        }catch (VmPersistenceException exc) {
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice");
        }
    }
}
