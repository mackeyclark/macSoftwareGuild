/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.Controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoException;
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
    //private UserIO io = new UserIOConsoleImpl();
    
    public DvdLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
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
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        }catch(DVDLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
            
        }
    }
    
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
        
    }
    
    private void createDVD() throws DVDLibraryDaoException{
        view.displayCreateDVDBanner();
        DVD newDvd = view.getNewDvdInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
        
    }
    
    private void listDVDs() throws DVDLibraryDaoException{
        view.displayDisplayAllBanner();
        List<DVD> DvdList = dao.getAllDVDs();
        view.displayDVDList(DvdList);
        
    }
    
    private void viewDVD() throws DVDLibraryDaoException{
        view.displayDisplayDVDBanner();
        String title = view.getDvdChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDvd(dvd);
        
    }
    
    private void removeDVD() throws DVDLibraryDaoException{
        view.displayRemoveDVDBanner();
        String title = view.getDvdChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
        
    }
    
    private void editDVD() throws DVDLibraryDaoException{
        view.displayEditDVDBanner();
        String title = view.getDvdChoice();
        DVD editDvd = view.getDVDEditInfo();
        dao.editDvd(title, editDvd);
        view.displayEditSuccessBanner();
        
    }
    
    private void unknownCommand(){
        view.displayErrorBanner();
        
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
}
