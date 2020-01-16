package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class Prompter {

    private Scanner sc = new Scanner(System.in);

    public void printWelcome() {
        System.out.println("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");
    }

    public void initMenu() {
        System.out.println("*** Main Menu ***");
        System.out.println("1 - List of Books");
        System.out.print("Please select an option by number: ");
        int selection = sc.nextInt();
        printSelection(selection);
    }

    private void printSelection(int selection) {
        switch (selection) {
            case 1:
                Books books = new Books();
                printBooks(books.getBooks());
        }
    }

    private void printBooks(ArrayList<Book> bookList) {
        System.out.println("*** Showing Books ***");
        System.out.println("*** Name | Author | Publish Date ***");
        for (Book book: bookList) {
            System.out.println(book.toListing());
        }
    }
}
