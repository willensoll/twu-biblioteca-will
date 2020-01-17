package com.twu.biblioteca;


public class Book {

    private String name;
    public String author;
    public int publishYear;

    public Book(String n, String a, int py) {
        name = n;
        author = a;
        publishYear = py;
    }

    public String toListing () {
        return name + " | " + author + " | " + publishYear;
    }

    public String getName() {
        return name;
    }
}
