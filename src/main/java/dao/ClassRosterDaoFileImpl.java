package dao;

import dto.Dvd;

import java.util.*;

public class ClassRosterDaoFileImpl implements ClassRosterDao {

    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public boolean addDvd(Dvd dvd) {
        if (dvds.containsKey(dvd.getTitle())) {
            return false;
        } else {
            dvds.put(dvd.getTitle(), dvd);
            return true;
        }
    }

    @Override
    public boolean removeDvd(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean editDvd(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Dvd> getAllDvds() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dvd getDvd(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
