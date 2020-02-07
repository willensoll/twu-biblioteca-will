package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IPrompter;

import java.util.ArrayList;

public class PrintBooks {

    private IPrompter _I_prompter;
    private ArrayList<Book> _bookList;

    public PrintBooks(IPrompter IPrompter, ArrayList bookList) {
        _I_prompter = IPrompter;
        _bookList = bookList;
    }

    public void run() {
        _I_prompter.printWithNewLine("*** Showing Books ***");
        _I_prompter.printWithNewLine("*** Name | Author | Publish Date ***");
        for (Book book: _bookList) {
            if (book.getAvailable()) {
                _I_prompter.printWithNewLine(book.toListing());
            }
        }
    }
}
