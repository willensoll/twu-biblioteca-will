package com.twu.biblioteca.classes;
import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        IPrompter IPrompter = new Prompter(System.out, new Scanner(System.in));
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(new Book("Catcher in the Rye", "J D Salinger", 1951));
        bookList.add(new Book("Ready Player One", "Ernest Cline", 2011));
        bookList.add(new Book("The Establishment", "Owen Jones", 2014));
        IMenu IMenu = new Menu(IPrompter, bookList);
        App app = new App(IPrompter, IMenu);
        app.start();
    }
}
