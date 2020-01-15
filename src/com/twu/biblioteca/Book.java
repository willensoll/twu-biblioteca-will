package com.twu.biblioteca;


public class Book {

    public String name;
    public String author;
    public String publishDate;

    public Book(String n, String a, String pd) {
        name = n;
        author = a;
        publishDate = pd;
    }

    public String toListing () {
        return name + " | " + author + " | " + publishDate;
    }
}
