package com.twu.biblioteca;

public class App {

    private IPrompter _I_prompter;
    private IMenu _I_menu;


    App(IPrompter IPrompter, IMenu IMenu) {
        _I_prompter = IPrompter;
        _I_menu = IMenu;
    }



    public void start() {
        printWelcome();
            _I_menu.initMenu();
    }



    private void printWelcome() {
        _I_prompter.printWithNewLine("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");
    }


}
