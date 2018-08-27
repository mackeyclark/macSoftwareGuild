/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary;

import com.dvdlibrary.Controller.DvdLibraryController;
import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/**
 *
 * @author macam
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
    }
}
