package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;

import java.util.ArrayList;

public class Menu extends Auth implements IMenu {

    private IPrompter _I_prompter;
    private Boolean _appInitialised;
    private ArrayList<Book> _bookList;
    private ArrayList<Movie> _movieList;
    private ReturnItem _returnItem;
    private CheckOutItem _checkoutItem;
    private LibraryItemPrinter _libraryItemPrinter;

    public Menu(IPrompter IPrompter, ArrayList bookList, ArrayList movieList, ArrayList userList) {
        super(IPrompter, userList);
        _I_prompter = IPrompter;
        _appInitialised = true;
        _bookList = bookList;
        _movieList = movieList;
    }

    public void initMenu() {
        while (_appInitialised) {
            if (super.getAuthenticated()) {
                initAuthMenu();
            } else {
                initUnAuthMenu();
            }
        }
    }

    private void initUnAuthMenu() {
        _I_prompter.printWithNewLine("*** Main Menu ***");
        _I_prompter.printWithNewLine("1 - Login");
        _I_prompter.printWithNewLine("2 - List of Books");
        _I_prompter.printWithNewLine("3 - List of Movies");
        _I_prompter.printWithNewLine("Q - Quit Biblioteca");
        _I_prompter.print("Please select an option by key: ");
        String selection = _I_prompter.readInput();
        printUnAuthSelection(selection);
    }

    private void initAuthMenu() {
        _I_prompter.printWithNewLine("*** Main Menu ***");
        _I_prompter.printWithNewLine("1 - List of Books");
        _I_prompter.printWithNewLine("2 - Check out Book");
        _I_prompter.printWithNewLine("3 - Return a book");
        _I_prompter.printWithNewLine("4 - List of Movies");
        _I_prompter.printWithNewLine("5 - Check out Movie");
        _I_prompter.printWithNewLine("6 - View checked out Books");
        _I_prompter.printWithNewLine("7 - View your details");
        _I_prompter.printWithNewLine("Q - Quit Biblioteca");
        _I_prompter.print("Please select an option by key: ");
        String selection = _I_prompter.readInput();
        printSelection(selection);
    }

    public void printUnAuthSelection(String selection) {
        switch (selection.toUpperCase()) {
            case "1":
                super.run();
                break;
            case "2":
                _libraryItemPrinter = new LibraryItemPrinter(_I_prompter, _bookList);
                _I_prompter.printWithNewLine("*** Showing Books ***");
                _libraryItemPrinter.printAvailableList();
            case "3":
                _libraryItemPrinter = new LibraryItemPrinter(_I_prompter, _movieList);
                _I_prompter.printWithNewLine("*** Showing Movies ***");
                _I_prompter.printWithNewLine("*** Name | Director | Publish Date | Star Rating ***");
                _libraryItemPrinter.printAvailableList();
            case "Q":
                quit();
                break;
        }
    }



    public void printSelection(String selection) {
        switch (selection.toUpperCase()) {
            case "1":
                _libraryItemPrinter = new LibraryItemPrinter(_I_prompter, _bookList);
                _I_prompter.printWithNewLine("*** Showing Books ***");
                _libraryItemPrinter.printAvailableList();
                break;
            case "2":
                _checkoutItem = new CheckOutItem(_I_prompter, _bookList, "book", super.get_authenticatedUser());
                _checkoutItem.checkOut();
                break;
            case "3":
                _returnItem = new ReturnItem(_I_prompter, _bookList, "book");
                _returnItem.returnItem();
                break;
            case "4":
                _libraryItemPrinter = new LibraryItemPrinter(_I_prompter, _movieList);
                _I_prompter.printWithNewLine("*** Showing Movies ***");
                _I_prompter.printWithNewLine("*** Name | Director | Publish Date | Star Rating ***");
                _libraryItemPrinter.printAvailableList();
                break;
            case "5":
                _checkoutItem = new CheckOutItem(_I_prompter, _movieList, "movie", super.get_authenticatedUser());
                _checkoutItem.checkOut();
                break;
            case "6":
                    _I_prompter.printWithNewLine("*** Showing Checked Out Books ***");
                    _I_prompter.printWithNewLine("*** Name | LibraryID ***");
                    _libraryItemPrinter = new LibraryItemPrinter(_I_prompter, _bookList);
                    _libraryItemPrinter.printCheckedOutList();
                    break;
            case "7":
                _I_prompter.printWithNewLine("*** Showing your information ***");
                _I_prompter.printWithNewLine("*** Name | Email | phone number ***");
                _I_prompter.printWithNewLine(super.get_authenticatedUser().getDetails());
                break;
            case "Q":
                quit();
                break;
            default:
                _I_prompter.printWithNewLine("Please Select a Valid Option!");
        }
    }

    public void quit() {
        _I_prompter.printWithNewLine("*** Thanks for using Biblioteca ***");
        _appInitialised = false;
    }
}