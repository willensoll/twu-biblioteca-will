package com.twu.biblioteca.classes;

public class LibraryItem {

    private String name;
    private String author;
    private int publishYear;
    private Boolean isAvailable;
    private String checkedOutBy;

    public LibraryItem(String n, String a, int py) {
        name = n;
        author = a;
        publishYear = py;
        isAvailable = true;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public String getName() {
        return name;
    }

    public Boolean setAvailability(Boolean bool) {
        isAvailable = bool;
        return isAvailable;
    }

    public String toListing () {
        return name + " | " + author + " | " + publishYear;
    }

    public String toListingLibView() { return name + " | " + checkedOutBy; }

    public String getCheckedOutBy() {
        return checkedOutBy;
    }

    public void setCheckedOutBy(String libraryId) {
        checkedOutBy = libraryId;
    }
}
