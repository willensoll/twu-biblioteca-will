package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;

import java.util.ArrayList;

public class Menu implements IMenu {

    private IPrompter _I_prompter;
    private Boolean _appInitialised;
    private ArrayList<Book> _bookList;
    private Library _library;

    public Menu(IPrompter IPrompter, ArrayList bookList) {
        _I_prompter = IPrompter;
        _appInitialised = true;
        _bookList = bookList;
        _library = new Library(_I_prompter, _bookList);
    }

    @Override
    public void initMenu() {
        while (_appInitialised) {
            _I_prompter.printWithNewLine("*** Main Menu ***");
            _I_prompter.printWithNewLine("1 - List of Books");
            _I_prompter.printWithNewLine("2 - Check out Book");
            _I_prompter.printWithNewLine("3 - Return a book");
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
                PrintBooks printBooks = new PrintBooks(_I_prompter, _bookList);
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
                _I_prompter.printWithNewLine("Please Select a Valid Option!");
        }
    }

    @Override
    public void quit() {
        _I_prompter.printWithNewLine("*** Thanks for using Biblioteca ***");
        _appInitialised = false;
    }
}
