package controller;

import dao.DvdLibraryDao;
import dao.DvdLibraryDaoException;
import dto.Dvd;
import ui.DvdLibraryView;

import java.util.List;

public class DvdLibraryController {

    private final DvdLibraryView view;
    private final DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        viewAllDvds();
                        break;
                    case 5:
                        searchByDvdTitle();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exit();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDvd() throws DvdLibraryDaoException {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getDvdInfo();
        view.displayAddDvdBanner(dao.addDvd(newDvd), newDvd.getTitle());
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        if (dvd == null) {
            view.displayDvdDoesNotExistError(title);
            view.displaySuccessfullyRemovedBanner(title);
        } else {
            dao.removeDvd(dvd);
        }
    }

    private void viewAllDvds() throws DvdLibraryDaoException {
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void searchByDvdTitle() throws DvdLibraryDaoException {
        view.displaySearchByDvdTitleBanner();
        String dvdTitleChoice = view.getDvdTitleChoice();
        Dvd dvdChoice = dao.getDvd(dvdTitleChoice);
        if (dvdChoice == null) {
            view.displayDvdDoesNotExistError(dvdTitleChoice);
        } else {
            view.displaySingleDvd(dvdChoice);
        }
    }

    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd oldDvd = dao.getDvd(title);
        if (oldDvd == null) {
            view.displayDvdDoesNotExistError(title);
            return;
        }
        view.displaySingleDvd(oldDvd);
        view.displayEditInstructions();
        Dvd newDvd = view.getDvdInfo();
        if (dao.editDvd(oldDvd, newDvd)) {
            view.displaySuccessfullyEditedBanner(title);
        } else {
            view.displayErrorMessage("Could not edit DVD.");
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exit() {
        view.displayExitBanner();
    }
}
