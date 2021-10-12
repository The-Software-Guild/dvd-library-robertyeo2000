package ui;

import dto.Dvd;

import java.util.Date;

public class ClassRosterView {

    private UserIO io;

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu:");
        io.print("1. Add DVD to collection");
        io.print("2. Remove DVD from collection");
        io.print("3. Edit info of existing DVD");
        io.print("4. View list of all DVDs in collection");
        io.print("5. View single DVD info");
        io.print("6. Quit");
        return io.readInt("Please select a number from above choices: ", 1, 6);
    }

    public Dvd getDvdInfo() {
        io.print("\nAdd DVD:");
        String title = io.readString("Title");
        Date releaseDate = io.readDate("Date (" + UserIOConsoleImpl.DATE_FORMAT + ")");
        String mpaaRating = io.readString("MPAA Rating");
        String directorName = io.readString("Director's Name");
        String studio = io.readString("Studio");
        String note = io.readString("Any extra notes");
        Dvd newDvd = new Dvd(title, releaseDate, mpaaRating, directorName, studio, note);
        return newDvd;
    }

    public void displayAddDvdBanner(boolean added, String dvdTitle) {
        if (added) {
            io.readString(dvdTitle + " Successfully Added. Press enter to continue.");
        } else {
            io.readString(dvdTitle + " NOT added as it was already in the library." +
                    " Press enter to continue");
        }
    }

}
