package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {

    public ArrayList bookList;


    Books () {
        bookList = new ArrayList();
        bookList.add("Catcher In The Rye");
        bookList.add("Ready Player One");
        bookList.add("The Establishment");
    }

    public ArrayList getBooks() {
        return bookList;
    }
}
