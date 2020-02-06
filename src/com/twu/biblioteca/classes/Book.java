package com.twu.biblioteca.classes;

public class Book {

    private String name;
    private String author;
    private int publishYear;
    private Boolean isAvailable;

    public Book(String n, String a, int py) {
        name = n;
        author = a;
        publishYear = py;
        isAvailable = true;
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

    public Boolean getAvailability() {
        return isAvailable;
    }

    public Boolean setAvailability(Boolean bool) {
        isAvailable = bool;
        return isAvailable;
    }
}
