package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;

import java.util.ArrayList;

public class Menu implements IMenu {

    private IPrompter _I_prompter;
    private Boolean _appInitialised;
    private ArrayList<Book> _bookList;
    private ArrayList<Movie> _movieList;
    private Library _library;
    private LibraryItemPrinter _libraryItemPrinter;

    public Menu(IPrompter IPrompter, ArrayList bookList, ArrayList movieList) {
        _I_prompter = IPrompter;
        _appInitialised = true;
        _bookList = bookList;
        _library = new Library(_I_prompter, _bookList);
        _movieList = movieList;
    }

    @Override
    public void initMenu() {
        while (_appInitialised) {
            _I_prompter.printWithNewLine("*** Main Menu ***");
            _I_prompter.printWithNewLine("1 - List of Books");
            _I_prompter.printWithNewLine("2 - Check out Book");
            _I_prompter.printWithNewLine("3 - Return a book");
            _I_prompter.printWithNewLine("4 - List of Movies");
            _I_prompter.printWithNewLine("Q - Quit Biblioteca");
            _I_prompter.print("Please select an option by key: ");
            String selection = _I_prompter.readInput();
            printSelection(selection);
        }
    }

    @Override
    public void printSelection(String selection) {
        switch (selection.toUpperCase()) {
            case "1":
                 _libraryItemPrinter = new LibraryItemPrinter(_I_prompter, _bookList);
                _I_prompter.printWithNewLine("*** Showing Books ***");
                _libraryItemPrinter.run();
                break;
            case "2":
                _library.checkOut();
                break;
            case "3":
                _library.returnBooks();
                break;
            case "4":
                _libraryItemPrinter = new LibraryItemPrinter(_I_prompter, _movieList);
                _I_prompter.printWithNewLine("*** Showing Movies ***");
                _I_prompter.printWithNewLine("*** Name | Director | Publish Date ***");
                _libraryItemPrinter.run();
                break;
            case "Q":
                quit();
                break;
            default:
                _I_prompter.printWithNewLine("Please Select a Valid Option!");
        }
    }

    @Override
    public void quit() {
        _I_prompter.printWithNewLine("*** Thanks for using Biblioteca ***");
        _appInitialised = false;
    }
}
