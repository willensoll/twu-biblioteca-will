package com.twu.biblioteca;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class Library {

    public ArrayList<Book> availableBookList;
    public ArrayList<Book> checkedOutBookList;
    public Prompter _prompter;

    public Library(Prompter prompter, ArrayList bookList) {
        availableBookList = bookList;
        checkedOutBookList = new ArrayList<>();
        _prompter = prompter;
    }

    public ArrayList getBooks() {
        return availableBookList;
    }

    public void checkOut() {
        _prompter.print("Enter name of Book to borrow: ");
        String itemToCheckOut = _prompter.readInput();
        try {
            Book book = validateBookRequest(itemToCheckOut, availableBookList);
            amendBookAvailabilityAfterCheckout(book);
            _prompter.printWithNewLine("Thank you! Enjoy the book");
        } catch (InvalidNameException exception) {
            _prompter.printWithNewLine("*** Sorry, that book is not available ***");
        }
    }

    public void returnBooks () {
        _prompter.print("Enter name of Book to return: ");
        String itemToCheckOut = _prompter.readInput();
        try {
            Book book = validateBookRequest(itemToCheckOut, checkedOutBookList);
            amendBookAvailabilityAfterReturn(book);
            _prompter.printWithNewLine("Thank you for returning the book");

        } catch (InvalidNameException exception) {
            _prompter.printWithNewLine("*** That is not a valid book to return ***");
        }
    }

    public void amendBookAvailabilityAfterCheckout(Book book) {
        availableBookList.remove(book);
        checkedOutBookList.add(book);
    }

    public void amendBookAvailabilityAfterReturn(Book book) {
        checkedOutBookList.remove(book);
        availableBookList.add(book);
    }

    public Book validateBookRequest(String bookName, ArrayList<Book> bookList) throws InvalidNameException {
        for (Book book: bookList) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        throw new InvalidNameException();
    }
}