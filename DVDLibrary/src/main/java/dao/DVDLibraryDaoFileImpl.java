/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author macam
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    
    private Map<String, DVD> Dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD newDVD = Dvds.put(title, dvd);
        return newDVD;
        
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(Dvds.values());
        
    }

    @Override
    public DVD getDVD(String title) {
        return Dvds.get(title);
        
    }

    @Override
    public DVD removeDVD(String title) {
        DVD removeDvd = Dvds.remove(title);
        return removeDvd;
        
    }
    
}
