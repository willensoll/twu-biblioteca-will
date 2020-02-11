package com.twu.biblioteca.interfaces;

public interface IMenu {
    void initMenu();

    void printSelection(String selection);

    void printUnAuthSelection(String selection);

    void quit();
}
