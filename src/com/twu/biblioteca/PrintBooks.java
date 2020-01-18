package com.twu.biblioteca;

import java.util.ArrayList;

public class PrintBooks {

    private Prompter _prompter;
    private ArrayList<Book> _bookList;

    PrintBooks(Prompter prompter, ArrayList bookList) {
        _prompter = prompter;
        _bookList = bookList;
    }


    public void run() {
        Books book1 = new Books(_prompter, _bookList);
             ArrayList<Book> bookList =   book1.getBooks();
        _prompter.printWithNewLine("*** Showing Books ***");
        _prompter.printWithNewLine("*** Name | Author | Publish Date ***");
        for (Book book: bookList) {
            _prompter.printWithNewLine(book.toListing());
        }
    }

}
