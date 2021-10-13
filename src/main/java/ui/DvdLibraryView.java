package ui;

import dto.Dvd;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DvdLibraryView {

    private final UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu:");
        io.print("1. Add DVD to collection");
        io.print("2. Remove DVD from collection");
        io.print("3. Edit info of existing DVD");
        io.print("4. View list of all DVDs in collection");
        io.print("5. Search by DVD title");
        io.print("6. Quit");
        return io.readInt("Please select a number from above choices: ", 1, 6);
    }

    public void displayAddDvdBanner() {
        io.print("\nAdd DVD:");
    }

    public Dvd getDvdInfo() {
        String title = io.readString("Title");
        Date releaseDate = io.readDate("Date (" + Dvd.DATE_FORMAT + ")");
        String mpaaRating = io.readString("MPAA Rating");
        String directorName = io.readString("Director's Name");
        String studio = io.readString("Studio");
        String note = io.readString("Any extra notes");
        return new Dvd(title, releaseDate, mpaaRating, directorName, studio, note);
    }

    public void displayAddDvdBanner(boolean added, String dvdTitle) {
        if (added) {
            io.print(dvdTitle + " Successfully Added.");
        } else {
            io.print(dvdTitle + " NOT added as it was already in the library.");
        }
        io.readString("Press enter to continue.");
    }

    public void displayDvdList(List<Dvd> DvdList) {
        io.print("Displaying all DVDs:");
        for (Dvd dvd : DvdList) {
            io.print(dvd.getTitle());
        }
        io.readString("Press enter to continue.");
    }

    public void displaySearchByDvdTitleBanner() {
        io.print("Search by DVD.");
    }

    public String getDvdTitleChoice() {
        return io.readString("Enter the title of the DVD: ");
    }

    public void displaySingleDvd(Dvd dvd) {
        DateFormat formatter = new SimpleDateFormat(Dvd.DATE_FORMAT);
        io.print("Title: " + dvd.getTitle());
        io.print("Released: " + formatter.format(dvd.getReleaseDate()));
        io.print("MPAA Rating: " + dvd.getMpaaRating());
        io.print("Director: " + dvd.getDirectorName());
        io.print("Studio: " + dvd.getStudio());
        io.print("Notes: " + dvd.getNote());
        io.readString("Press enter to continue.");
    }

    public void displayDvdDoesNotExistError(String title) {
        io.print("There is no DVD with title '" + title + "' in the library.");
        io.readString("Press enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("Remove DVD.");
    }

    public void displaySuccessfullyRemovedBanner(String title) {
        io.print(title + " successfully removed.");
        io.readString("Press enter to continue.");
    }

    public void displayEditDvdBanner() {
        io.print("Edit DVD.");
    }

    public void displayEditInstructions() {
        io.print("Now enter the details of the DVD you wish to replace it with.");
    }

    public void displaySuccessfullyEditedBanner(String oldTitle) {
        io.print(oldTitle + " successfully edited.");
        io.readString("Press enter to continue.");
    }

    public void displayUnknownCommandBanner() {
        io.print("Error. Unknown Command. Please try again with one of the above menu options.");
    }

    public void displayExitBanner() {
        io.print("Good bye.");
    }
}
