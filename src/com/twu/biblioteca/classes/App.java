package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;

public class App {

    private IPrompter _I_prompter;
    private IMenu _I_menu;


    public App(IPrompter IPrompter, IMenu IMenu) {
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
