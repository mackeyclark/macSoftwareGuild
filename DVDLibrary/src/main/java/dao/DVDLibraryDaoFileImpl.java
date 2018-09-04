/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author macam
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> Dvds = new HashMap<>();

    public DVDLibraryDaoFileImpl() {
        try {
            loadLibrary();
        } catch (Exception ex) {
        }
    }

    @Override
    public DVD addDVD(DVD dvd) throws DVDLibraryDaoException {
        DVD newDVD = Dvds.put(dvd.getTitle(), dvd);
        writeLibrary();
        return newDVD;

    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        return new ArrayList<DVD>(Dvds.values());

    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        return Dvds.get(title);

    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        DVD removeDvd = Dvds.remove(title);
        writeLibrary();
        return removeDvd;

    }

    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));

        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("-_- could not load library data into memory", e);

        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDvd = new DVD(currentTokens[0]);
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setDirector(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);

            Dvds.put(currentDvd.getTitle(), currentDvd);
        }

        scanner.close();
    }

    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));

        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save DVD data.", e);

        }

        List<DVD> DvdList = this.getAllDVDs();
        for (DVD currentDvd : DvdList) {
            out.println(currentDvd.getTitle() + DELIMITER + currentDvd.getReleaseDate() + DELIMITER + currentDvd.getMpaaRating() + DELIMITER + currentDvd.getDirector() + DELIMITER + currentDvd.getStudio() + DELIMITER + currentDvd.getUserRating());
            out.flush();

        }
        out.close();

    }

    @Override
    public void editDvd(String oldTitle, DVD editDvd) throws DVDLibraryDaoException {
        //remove based on old title
        //add new dvd USING NEW TITLE
        Dvds.remove(oldTitle);
        Dvds.put(editDvd.getTitle(), editDvd);
        writeLibrary();
        
    }

}
