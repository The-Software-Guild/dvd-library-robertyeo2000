package dao;

import dto.Dvd;

import java.util.List;

public interface DvdLibraryDao {

    boolean addDvd(Dvd dvd);

    boolean removeDvd(Dvd dvd);

    boolean editDvd(Dvd oldDvd, Dvd newDvd);

    List<Dvd> getAllDvds();

    Dvd getDvd(String dvdTitle);

}
