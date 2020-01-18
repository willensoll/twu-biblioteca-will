package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Prompter prompter = new Prompter(System.out, new Scanner(System.in));
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(new Book("Catcher in the Rye", "J D Salinger", 1951));
        bookList.add(new Book("Ready Player One", "Ernest Cline", 2011));
        bookList.add(new Book("The Establishment", "Owen Jones", 2014));
        Menu menu = new Menu(prompter, bookList);
        App app = new App(prompter, menu);
        app.start();
    }
}
