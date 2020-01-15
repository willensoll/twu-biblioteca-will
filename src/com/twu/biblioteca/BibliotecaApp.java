package com.twu.biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
    Prompter prompter = new Prompter();
    prompter.welcomeMessage();
    Books books = new Books();
    prompter.printBooks(books.getBooks());
    }
}
