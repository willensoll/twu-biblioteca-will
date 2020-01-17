package com.twu.biblioteca;

import java.util.ArrayList;

public class PrintBooks {

    Prompter _prompter;

    PrintBooks(Prompter prompter) {
        _prompter = prompter;
    }


    public void run() {
        Books book1 = new Books();
             ArrayList<Book> bookList =   book1.getBooks();
        _prompter.printWithNewLine("*** Showing Books ***");
        _prompter.printWithNewLine("*** Name | Author | Publish Date ***");

        for (Book book: bookList) {
            _prompter.printWithNewLine(book.toListing());
        }
    }

}
