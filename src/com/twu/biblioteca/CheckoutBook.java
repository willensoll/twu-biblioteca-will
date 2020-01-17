package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckoutBook {

    Prompter _prompter;

    CheckoutBook(Prompter prompter) {
        _prompter = prompter;
    }

    public void checkOut() {
        _prompter.print("Enter name of Book: ");
        String itemToCheckOut = _prompter.readInput();
        validateBookRequest(itemToCheckOut);
    }

        public Boolean validateBookRequest(String bookName) {
            Books books = new Books();
            ArrayList<Book> bookList = books.getBooks();

            for (Book book: bookList) {
                if (book.getName().equalsIgnoreCase(bookName)) {
                    return true;
                }
            }
            return false;
        }
    }
