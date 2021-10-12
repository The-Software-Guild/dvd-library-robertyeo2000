package dao;

import dto.Dvd;

import java.util.List;

public interface ClassRosterDao {

    boolean addDvd(Dvd dvd);

    boolean removeDvd(Dvd dvd);

    boolean editDvd(Dvd dvd);

    List<Dvd> getAllDvds();

    Dvd getDvd(Dvd dvd);

}
