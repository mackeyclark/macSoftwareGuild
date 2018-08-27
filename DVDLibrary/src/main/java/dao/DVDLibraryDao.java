/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DVD;
import java.util.List;

/**
 *
 * @author macam
 */
public interface DVDLibraryDao {
    
    /**
     * Adds a new DVD to the library and associates it with the title given. If
     * there is a DVD object already associated with a title it will return that
     * DVD object, else it will return null.
     * 
     * @param title id with which DVD is to be associated
     * @param DVD dvd to be added to the library
     * @return the DVD object previously associated with the given title if it
     * exists, null otherwise
     */
    DVD addDVD(String title, DVD dvd);
    
    /**
     * Returns a String array containing the titles of all DVDs in the library
     * 
     * @return String array containing the titles of all the DVDs in the library
     */
    List<DVD> getAllDVDs();
    
    /**
     * Returns the DVD object associated with the given title. Returns null if
     * no such DVD exists.
     * 
     * @param title of the DVD to retrieve.
     * @return The DVD object associated with the given title, null if no such
     * DVD exists
     */
    DVD getDVD(String title);
    
    /**
     * Removes from the library the DVD associated with the given title. Returns
     * the DVD object that is being removed or null if there is no DVD
     * associated with the given title.
     * 
     * @param title id of the DVD to be removed
     * @return DVD object that was removed or null if no DVD was associated with
     * the given title
     */
    DVD removeDVD(String title);
    
}
