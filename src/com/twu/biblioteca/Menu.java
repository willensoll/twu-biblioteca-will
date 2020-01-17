package com.twu.biblioteca;

public class Menu {

    private Prompter _prompter;
    private Boolean _appInitialised;

    Menu(Prompter prompter) {
        _prompter = prompter;
        _appInitialised = true;
    }

    public void initMenu() {
        while (_appInitialised) {
            _prompter.printWithNewLine("*** Main Menu ***");
            _prompter.printWithNewLine("1 - List of Books");
            _prompter.printWithNewLine("2 - Check out Book");
            _prompter.printWithNewLine("Q - Quit Biblioteca");
            _prompter.print("Please select an option by number: ");
            String selection = _prompter.readInput();
            printSelection(selection);
        }
    }

    public void printSelection(String selection) {
        switch (selection.toUpperCase()) {
            case "1":
                PrintBooks books = new PrintBooks(_prompter);
                books.run();
                break;
            case "2":
                CheckoutBook checkout = new CheckoutBook(_prompter);
                checkout.checkOut();
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
