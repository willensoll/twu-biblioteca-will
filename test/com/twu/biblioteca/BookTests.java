package com.twu.biblioteca;

import com.twu.biblioteca.classes.Book;
import org.junit.Before;
import org.junit.Test;

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
    public void book_has_isAvailable_boolean_defaults_to_true() { assertThat(testBook.getAvailable(), is(true)); }

    @Test
    public void setAvailability_alters_books_boolean() {
        assertThat(testBook.setAvailability(false), is(false));
    }

};