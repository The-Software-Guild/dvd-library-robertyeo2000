package controller;

import dao.DvdLibraryDao;
import dto.Dvd;
import ui.DvdLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

import java.util.List;

public class DvdLibraryController {

    private final DvdLibraryView view;
    private final DvdLibraryDao dao;
    private final UserIO io = new UserIOConsoleImpl();

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    // TODO: 12/10/2021  
                    io.print("REMOVE DVD");
                    break;
                case 3:
                    // TODO: 12/10/2021  
                    io.print("EDIT DVD INFO");
                    break;
                case 4:
                    viewAllDvds();
                    break;
                case 5:
                    // TODO: 12/10/2021  
                    viewSingleDvd();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    // TODO: 12/10/2021  
                    io.print("OTHER CASE");
                    break;
            }
        }
        // TODO: 12/10/2021  
        io.print("GOODBYE!!");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDvd() {
        Dvd newDvd = view.getDvdInfo();
        view.displayAddDvdBanner(dao.addDvd(newDvd), newDvd.getTitle());
    }

    private void viewAllDvds() {
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewSingleDvd() {
        String dvdTitleChoice = view.getDvdTitleChoice();
        Dvd dvdChoice = dao.getDvd(dvdTitleChoice);
        if (dvdChoice == null) {
            view.dvdDoesNotExist(dvdTitleChoice);
        } else {
            view.displaySingleDvd(dvdChoice);
        }
    }
}
