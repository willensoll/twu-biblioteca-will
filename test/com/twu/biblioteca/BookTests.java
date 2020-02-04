package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BookTests {

    private Book testBook;

    @Before
    public void initBook() {
        testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
    }

    @Test
    public void book_has_name_value() {
        assertThat(testBook.getName(), is("Catcher in the Rye"));
    }

    @Test
    public void book_has_author_value() {
        assertThat(testBook.getAuthor(), is("J D Salinger"));
    }

    @Test
    public void book_has_publishedDate_value() {
        assertThat(testBook.getPublishYear(), is(1951));
    }

    @Test
    public void toListing_returns_book_in_correct_format() {
        String test = testBook.toListing();
        assertThat(test, is("Catcher in the Rye | J D Salinger | 1951"));
    }

    @Test
    public void book_has_isAvailable_boolean() { assertThat(testBook.getAvailability(), is(true)); }

};
