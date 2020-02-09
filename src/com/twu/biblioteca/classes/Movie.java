package com.twu.biblioteca.classes;

public class Movie extends LibraryItem {
    private String name;
    private String author;
    private int publishYear;


    private String starRating;

    public Movie(String n, String a, int py, String sr) {
        super(n,  a,  py);
        name = super.getName();
        author = super.getAuthor();
        publishYear = super.getPublishYear();
        starRating = sr;
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

    public String getStarRating() {
        return starRating;
    }

    @Override
    public String toListing() {
        return name + " | " + author + " | " + publishYear + " | " + starRating;
    }
}
