/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachine01.app;

import com.vendingmachine01.view.UserIO;
import com.vendingmachine01.view.UserIOConsoleImpl;
import com.vendingmachine01.dao.VmDao;
import com.vendingmachine01.dao.VmFileImpl;
import com.vendingmachine01.controller.VmController;
import com.vendingmachine01.controller.VmControllerImpl;
import com.vendingmachine01.service.VmService;
import com.vendingmachine01.service.VmServiceImpl;
import com.vendingmachine01.view.VmView;
import com.vendingmachine01.view.VmViewImpl;

/**
 *
 * @author macam
 */
public class App {
    
    public static void main(String[] args) throws UnsupportedOperationException{
        UserIO myIo = new UserIOConsoleImpl();
        VmDao dao = new VmFileImpl();
        VmService service = new VmServiceImpl(dao);
        VmView view = new VmViewImpl(myIo);
        VmController controller = new VmControllerImpl(service, view);
        controller.run();
    }
    
}
