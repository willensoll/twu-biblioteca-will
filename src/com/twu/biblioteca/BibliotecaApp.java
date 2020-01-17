package com.twu.biblioteca;

public class BibliotecaApp {

    private Prompter _prompter;
    private Menu _menu;


    BibliotecaApp(Prompter prompter, Menu menu) {
        _prompter = prompter;
        _menu = menu;
    }



    public void start() {
        printWelcome();
            _menu.initMenu();
    }



    private void printWelcome() {
        _prompter.printWithNewLine("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");
    }


}
