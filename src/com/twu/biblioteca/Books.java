package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Books {

    public ArrayList<Book> bookList;


    Books () {
        bookList = new ArrayList();
        bookList.add(new Book("Catcher in the Rye", "J D Salinger", 1951));
        bookList.add(new Book("Ready Player One", "Ernest Cline", 2011));
        bookList.add(new Book("The Establishment", "Owen Jones", 2014));
    }

    public ArrayList getBooks() {
        return bookList;
    }


}
