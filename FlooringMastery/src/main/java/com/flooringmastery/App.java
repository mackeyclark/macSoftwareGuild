/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmastery;

import com.flooringmastery.controller.FmController;
import com.flooringmastery.controller.FmControllerImpl;
import com.flooringmastery.dao.FmDao;
import com.flooringmastery.dao.FmDaoFileImpl;
import com.flooringmastery.service.FmServiceLayer;
import com.flooringmastery.service.FmServiceLayerImpl;
import com.flooringmastery.view.FmView;
import com.flooringmastery.view.FmViewImpl;

/**
 *
 * @author macam
 */
public class App {
    
    public static void main(String[] args) {
        FmView view = new FmViewImpl();
        FmDao dao = new FmDaoFileImpl(view);
        FmServiceLayer service = new FmServiceLayerImpl(dao);
        FmController controller = new FmControllerImpl(view, service);
        controller.run();
    }
    
}
