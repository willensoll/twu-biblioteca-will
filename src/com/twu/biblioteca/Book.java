package com.twu.biblioteca;


public class Book {

    private String name;
    private String author;
    private int publishYear;

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

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

}
