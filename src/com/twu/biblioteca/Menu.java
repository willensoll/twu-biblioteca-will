package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    private Prompter _prompter;
    private Boolean _appInitialised;
    private ArrayList<Book> _bookList;
    private Library _library;

    Menu(Prompter prompter, ArrayList bookList) {
        _prompter = prompter;
        _appInitialised = true;
        _bookList = bookList;
        _library = new Library(_prompter, _bookList);
    }

    public void initMenu() {
        while (_appInitialised) {
            _prompter.printWithNewLine("*** Main Menu ***");
            _prompter.printWithNewLine("1 - List of Books");
            _prompter.printWithNewLine("2 - Check out Book");
            _prompter.printWithNewLine("3 - Return a book");
            _prompter.printWithNewLine("Q - Quit Biblioteca");
            _prompter.print("Please select an option by number: ");
            String selection = _prompter.readInput();
            printSelection(selection);
        }
    }

    public void printSelection(String selection) {
        switch (selection.toUpperCase()) {
            case "1":
                PrintBooks printBooks = new PrintBooks(_prompter, _bookList);
                printBooks.run();
                break;
            case "2":
                _library.checkOut();
                break;
            case "3":
                _library.returnBooks();
                break;
            case "Q":
                quit();
                break;
            default:
                _prompter.printWithNewLine("Please Select a Valid Option!");
        }
    }

    public void quit() {
        _prompter.printWithNewLine("*** Thanks for using Biblioteca ***");
        _appInitialised = false;
    }
}
