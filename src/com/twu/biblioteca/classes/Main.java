package com.twu.biblioteca.classes;
import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IPrompter IPrompter = new Prompter(System.out, new Scanner(System.in));
        ArrayList<Book> bookList = new ArrayList();
        ArrayList<Movie> movieList = new ArrayList();
        ArrayList<User> userList = new ArrayList();

        bookList.add(new Book("Catcher in the Rye", "J D Salinger", 1951));
        bookList.add(new Book("Ready Player One", "Ernest Cline", 2011));
        bookList.add(new Book("The Establishment", "Owen Jones", 2014));

        movieList.add(new Movie("Up", "Pete Docter", 2009, "4.7"));
        movieList.add(new Movie("Train to Busan", "Yeon Sang-ho", 2016, "4.9"));
        movieList.add(new Movie("Gladiator", "Ridley Scott", 2000, "4.8"));

        userList.add(new User("123-4567", "password","will", "email@email.com", "07777777777"));
        userList.add(new User("098-7654", "password", "will","email@email.com", "07777777777"));
        Auth auth = new Auth(IPrompter, userList);
        IMenu IMenu = new Menu(IPrompter, bookList, movieList, auth);
        App app = new App(IPrompter, IMenu);
        app.start();
    }
}
