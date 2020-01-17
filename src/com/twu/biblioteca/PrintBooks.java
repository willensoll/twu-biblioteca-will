package com.twu.biblioteca;

import java.util.ArrayList;

public class PrintBooks {

    public void run() {
        Books book1 = new Books();
             ArrayList<Book> bookList =   book1.getBooks();
        System.out.println("*** Showing Books ***");
        System.out.println("*** Name | Author | Publish Date ***");

        for (Book book: bookList) {
            System.out.println(book.toListing());
        }
    }

}
