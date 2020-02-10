package com.twu.biblioteca.classes;

public class Book extends LibraryItem {

    private String name;
    private String author;
    private int publishYear;

    public Book(String n, String a, int py) {
        super(n,  a,  py);
         name = super.getName();
         author = super.getAuthor();
         publishYear = super.getPublishYear();
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