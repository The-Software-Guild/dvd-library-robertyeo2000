package dao;

import dto.Dvd;

import java.util.List;

public interface DvdLibraryDao {

    boolean addDvd(Dvd dvd);

    boolean removeDvd(Dvd dvd);

    boolean editDvd(Dvd dvd);

    List<Dvd> getAllDvds();

    Dvd getDvd(String dvdTitle);

}
