package dao;

import dto.Dvd;

import java.util.List;

public interface DvdLibraryDao {

    boolean addDvd(Dvd dvd) throws DvdLibraryDaoException;

    boolean removeDvd(Dvd dvd) throws DvdLibraryDaoException;

    boolean editDvd(Dvd oldDvd, Dvd newDvd) throws DvdLibraryDaoException;

    List<Dvd> getAllDvds() throws DvdLibraryDaoException;

    Dvd getDvd(String dvdTitle) throws DvdLibraryDaoException;

}
