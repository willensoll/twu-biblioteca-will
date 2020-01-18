package com.twu.biblioteca;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class Books {

    public ArrayList<Book> availableBookList;
    public ArrayList<Book> checkedOutBookList;
    public Prompter _prompter;

    public Books (Prompter prompter, ArrayList bookList) {
        availableBookList = bookList;
        checkedOutBookList = new ArrayList<>();
        _prompter = prompter;
    }

    public ArrayList getBooks() {
        return availableBookList;
    }

    public void checkOut() {
        _prompter.print("Enter name of Book: ");
        String itemToCheckOut = _prompter.readInput();
        try {
            Book book = validateBookRequest(itemToCheckOut);
            amendBookAvailability(book);
        } catch (InvalidNameException exception) {
            _prompter.printWithNewLine("*** That item is not available ***");
        }
    }

    public void amendBookAvailability(Book book) {
        availableBookList.remove(book);
        checkedOutBookList.add(book);
    }

    public Book validateBookRequest(String bookName) throws InvalidNameException {
        for (Book book: availableBookList) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        throw new InvalidNameException();
    }
}