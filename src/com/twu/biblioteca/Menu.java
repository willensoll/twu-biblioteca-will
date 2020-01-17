package com.twu.biblioteca;

public class Menu {

    private Prompter _prompter;

    Menu(Prompter prompter) {
        _prompter = prompter;
    }

    public void initMenu() {
        while (true) {
            _prompter.printWithNewLine("*** Main Menu ***");
            _prompter.printWithNewLine("1 - List of Books");
            _prompter.printWithNewLine("Q - Quit Biblioteca");
            _prompter.print("Please select an option by number: ");
            String selection = _prompter.readInput();
            printSelection(selection);
        }
    }

    public void printSelection(String selection) {
        switch (selection.toUpperCase()) {
            case "1":
                PrintBooks books = new PrintBooks();
                books.run();
                break;
            case "Q":
                quit();
            default:
                _prompter.printWithNewLine("Please Select a Valid Option!");
        }
    }

    public void quit() {
        System.exit(0);
    }

}
