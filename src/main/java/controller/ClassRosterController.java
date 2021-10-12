package controller;

import dao.ClassRosterDao;
import dto.Dvd;
import ui.ClassRosterView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class ClassRosterController {

    private ClassRosterView view;
    private ClassRosterDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
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
                    // TODO: 12/10/2021  
                    io.print("VIEW ALL DVDs");
                    break;
                case 5:
                    // TODO: 12/10/2021  
                    io.print("VIEW SINGLE DVD");
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
}
