package com.twu.biblioteca;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Books {

    public ArrayList<Book> availableBookList;
    public ArrayList<Book> checkedOutBookList;
    public Prompter _prompter;



    Books (Prompter prompter) {
        availableBookList = new ArrayList();
        checkedOutBookList = new ArrayList();
        availableBookList.add(new Book("Catcher in the Rye", "J D Salinger", 1951));
        availableBookList.add(new Book("Ready Player One", "Ernest Cline", 2011));
        availableBookList.add(new Book("The Establishment", "Owen Jones", 2014));
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
            availableBookList.remove(book);
            checkedOutBookList.add(book);
        } catch (InvalidNameException exception) {
            _prompter.printWithNewLine("*** That item is not available ***");
        }
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
