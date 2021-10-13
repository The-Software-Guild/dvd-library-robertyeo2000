package dao;

import dto.Dvd;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    private final Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public boolean addDvd(Dvd dvd) throws DvdLibraryDaoException {
        loadDvd();
        if (dvds.containsKey(dvd.getTitle())) {
            return false;
        } else {
            dvds.put(dvd.getTitle(), dvd);
            writeDvd();
            return true;
        }
    }

    @Override
    public boolean removeDvd(Dvd dvd) throws DvdLibraryDaoException {
        loadDvd();
        if (dvds.containsKey(dvd.getTitle())) {
            dvds.remove(dvd.getTitle(), dvd);
            writeDvd();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editDvd(Dvd oldDvd, Dvd newDvd) throws DvdLibraryDaoException {
        if (removeDvd(oldDvd)) {
            addDvd(newDvd);
            return true;
        }
        return false;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadDvd();
        return new ArrayList<>(dvds.values());
    }

    @Override
    public Dvd getDvd(String dvdTitle) throws DvdLibraryDaoException {
        loadDvd();
        return dvds.get(dvdTitle);
    }

    private Dvd unmarshallDvd(String dvdAsText) throws DvdLibraryDaoException {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        Date releaseDate;
        try {
            releaseDate = Dvd.DATE_FORMAT.parse(dvdTokens[1]);
        } catch (ParseException e) {
            throw new DvdLibraryDaoException("Could not convert one of the dates from file into memory.", e);
        }
        String mpaaRating = dvdTokens[2];
        String director = dvdTokens[3];
        String studio = dvdTokens[4];
        String notes = dvdTokens[5];
        return new Dvd(title, releaseDate, mpaaRating, director, studio, notes);
    }

    private void loadDvd() throws DvdLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("Could not load data into memory", e);
        }
        String currentLine;
        Dvd currentDvd;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    private String marshallDvd(Dvd dvd) {
        String dvdAsText = dvd.getTitle() + DELIMITER;
        dvdAsText += Dvd.DATE_FORMAT.format(dvd.getReleaseDate()) + DELIMITER;
        dvdAsText += dvd.getMpaaRating() + DELIMITER;
        dvdAsText += dvd.getDirectorName() + DELIMITER;
        dvdAsText += dvd.getStudio() + DELIMITER;
        dvdAsText += dvd.getNote();
        return dvdAsText;
    }

    private void writeDvd() throws DvdLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save DVD data", e);
        }
        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
