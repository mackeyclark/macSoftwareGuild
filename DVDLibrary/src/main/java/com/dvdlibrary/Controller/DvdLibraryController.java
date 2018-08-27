/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.Controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import dto.DVD;
import java.util.List;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/**
 *
 * @author macam
 */
public class DvdLibraryController {
    
    DVDLibraryView view;
    DVDLibraryDao dao;
    private UserIO io = new UserIOConsoleImpl();
    
    public DvdLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing){
            
            menuSelection = getMenuSelection();
            
            switch(menuSelection){
                case 1:
                    createDVD();
                    break;
                case 2:
                    listDVDs();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                    io.print("EDIT DVD");
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }
    
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
        
    }
    
    private void createDVD(){
        view.displayCreateDVDBanner();
        DVD newDvd = view.getNewDvdInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
        
    }
    
    private void listDVDs(){
        view.displayDisplayAllBanner();
        List<DVD> DvdList = dao.getAllDVDs();
        view.displayDVDList(DvdList);
        
    }
    
    private void viewDVD(){
        view.displayDisplayDVDBanner();
        String title = view.getDvdChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDvd(dvd);
        
    }
    
    private void removeDVD(){
        view.displayRemoveDVDBanner();
        String title = view.getDvdChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
        
    }
    
    private void unknownCommand(){
        view.displayErrorBanner();
        
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
}
