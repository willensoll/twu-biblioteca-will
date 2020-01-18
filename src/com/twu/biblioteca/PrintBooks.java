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
        _prompter.printWithNewLine("*** Showing Books ***");
        _prompter.printWithNewLine("*** Name | Author | Publish Date ***");
        for (Book book: _bookList) {
            _prompter.printWithNewLine(book.toListing());
        }
    }
}
