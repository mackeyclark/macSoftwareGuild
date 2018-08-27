/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dto.DVD;
import java.util.List;

/**
 *
 * @author macam
 */
public class DVDLibraryView {
    
    private UserIO io;
    
    public DVDLibraryView(UserIO io){
        
    }
    
    public int printMenuAndGetSelection(){
        io.print("MAIN MENU");
        io.print("1. Add Title");
        io.print("2. List Titles");
        io.print("3. Search Titles");
        io.print("4. Remove Title");
        io.print("5. Edit Title");
        io.print("6. Exit");
            
        return io.readInt("Please Select form the above choices.", 1, 6);
            
    }
    
    public DVD getNewDvdInfo(){
        String title = io.readString("Please enter the movie title");
        String releaseDate = io.readString("Please enter the date the movie was released");
        String mpaaRating = io.readString("Plese enter the official MPAA rating");
        String director = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the studio name");
        String userRating = io.readString("Please enter any additional notes about the movie");
        DVD currentDvd = new DVD(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirector(director);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        return currentDvd;
        
    }
    
    public void displayCreateDVDBanner(){
        io.print("=== Create DVD ===");
        
    }
    
    public void displayCreateSuccessBanner(){
        io.print("DVD successfully created. Please hit enter to contine");
        
    }
    
    public void displayDVDList(List<DVD> DvdList){
        for(DVD currentDvd : DvdList){
            io.print(currentDvd.getTitle() + ": " + currentDvd.getUserRating());
        }
        io.readString("Please hit enter to continue");
        
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All DVDs ===");
        
    }
    
    public void displayDisplayDVDBanner(){
        io.print("=== Display DVD ===");
        
    }
    
    public String getDvdChoice(){
        return io.readString("Please enter the movie's title.");
        
    }
    
    public void displayDvd(DVD dvd){
        if(dvd != null){
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print(" ");
            
        }else{
            io.print("No such movie.");
            
        }
        io.readString("Please hit enter to continue.");
        
    }
    
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
        
    }
    
    public void displayRemoveSuccessBanner(){
        io.readString("DVD successfully removed. Please hit enter to continue.");
        
    }
    
    public void displayExitBanner(){
        io.print("GOOD BYE!!!");
        
    }
    
    public void displayErrorBanner(){
        io.print("UNKNOWN COMMAND");
        
    }
    
}
