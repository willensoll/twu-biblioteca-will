package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BooksTests {

    @Test
    public void books_creates_books_list() {
        Books bookList = new Books();
        ArrayList test = bookList.getBooks();
        assertThat(3, is(test.size()));    }


    @Test
    public void book_has_name_value() {
        Book testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        assertThat(testBook.name, is("Catcher in the Rye"));
    }

    @Test
    public void book_has_author_value() {
        Book testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        assertThat(testBook.author, is("J D Salinger"));
    }

    @Test
    public void book_has_publishedDate_value() {
        Book testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        assertThat(testBook.publishYear, is(1951));
    }

    @Test
    public void getBookName_returns_name_of_book() {
        Book testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        String test = testBook.toListing();
        assertThat(test, is("Catcher in the Rye | J D Salinger | 1951"));
    }
};
