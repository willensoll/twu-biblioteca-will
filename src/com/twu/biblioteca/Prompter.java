package com.twu.biblioteca;

import java.util.ArrayList;

public class Prompter {
    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");
    }

    public void printBooks(ArrayList<String> bookList) {
        for (String book: bookList) {
            System.out.println(book);
        }
    }
}
