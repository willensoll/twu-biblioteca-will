package com.twu.biblioteca;

import java.util.ArrayList;

public class PrintBooks {

    private IPrompter _I_prompter;
    private ArrayList<Book> _bookList;

    PrintBooks(IPrompter IPrompter, ArrayList bookList) {
        _I_prompter = IPrompter;
        _bookList = bookList;
    }

    public void run() {
        _I_prompter.printWithNewLine("*** Showing Books ***");
        _I_prompter.printWithNewLine("*** Name | Author | Publish Date ***");
        for (Book book: _bookList) {
            if (book.getAvailability()) {
                _I_prompter.printWithNewLine(book.toListing());
            }
        }
    }
}
