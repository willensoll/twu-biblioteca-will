package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {

    public ArrayList bookList;


    Books () {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Catcher in the Rye", "J D Salinger", "16 July 1951"));
        bookList.add(new Book("Ready Player One", "Ernest Cline", "16 August 2011"));
        bookList.add(new Book("The Establishment", "Owen Jones", "4 September 2014"));
    }

    public ArrayList getBooks() {
        return bookList;
    }
}
