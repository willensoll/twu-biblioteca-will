package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IPrompter;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class Library {

    public ArrayList<Book> availableBookList;
    private IPrompter _I_prompter;

    public Library(IPrompter IPrompter, ArrayList bookList) {
        availableBookList = bookList;
        _I_prompter = IPrompter;
    }

    public ArrayList getBooks() {
        return availableBookList;
    }

    public void checkOut() {
        _I_prompter.print("Enter name of Book to borrow: ");
        String itemToCheckOut = _I_prompter.readInput();
        try {
            Book book = validateBookRequest(itemToCheckOut, true);
            amendBookAvailabilityAfterCheckout(book);
            _I_prompter.printWithNewLine("Thank you! Enjoy the book");
        } catch (InvalidNameException exception) {
            _I_prompter.printWithNewLine("*** Sorry, that book is not available ***");
        }
    }

    public void returnBooks () {
        _I_prompter.print("Enter name of Book to return: ");
        String itemToCheckOut = _I_prompter.readInput();
        try {
            Book book = validateBookRequest(itemToCheckOut, false);
            amendBookAvailabilityAfterReturn(book);
            _I_prompter.printWithNewLine("Thank you for returning the book");

        } catch (InvalidNameException exception) {
            _I_prompter.printWithNewLine("*** That is not a valid book to return ***");
        }
    }

    public void amendBookAvailabilityAfterCheckout(Book book) {
        book.setAvailability(false);
    }

    public void amendBookAvailabilityAfterReturn(Book book) {
        book.setAvailability(true);
    }

    public Book validateBookRequest(String bookName, Boolean availableStatus) throws InvalidNameException {
        for (Book book: availableBookList) {
            if (book.getName().equalsIgnoreCase(bookName) && book.getAvailable().equals(availableStatus)) {
                return book;
            }
        }
        throw new InvalidNameException();
    }
}