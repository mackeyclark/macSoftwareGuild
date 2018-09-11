/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.app;

import com.vendingmachine01.controller.VmController;
import com.vendingmachine01.controller.VmControllerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author macam
 */
public class App {
    
    public static void main(String[] args) throws UnsupportedOperationException{
//        UserIO myIo = new UserIOConsoleImpl();
//        VmDao dao = new VmFileImpl();
//        VmAuditDao auditDao = new VmAuditFileImpl();
//        VmService service = new VmServiceImpl(dao, auditDao);
//        VmView view = new VmViewImpl(myIo);
//        VmController controller = new VmControllerImpl(service, view);
//        controller.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VmControllerImpl controller = ctx.getBean("controller", VmControllerImpl.class);
        controller.run();
    }
}
