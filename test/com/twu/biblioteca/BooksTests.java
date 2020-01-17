package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BooksTests {

    private Books books;
    private Prompter prompterMock;
    private Book testBook;

    @Before
    public void initBooksTests () {

        prompterMock = mock(Prompter.class);
        books = new Books(prompterMock);
        testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);

    }

    @Test
    public void books_creates_books_list() {
        ArrayList test = books.getBooks();
        assertThat(3, is(test.size()));    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_list() throws InvalidNameException {
        Book test = books.validateBookRequest("Catcher in the Rye");
        assertThat(test.toListing(), is(testBook.toListing()));
    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_list_ignores_case() throws InvalidNameException {
        Book test = books.validateBookRequest("CATCHer in the rYe");
        assertThat(test.toListing(), is(testBook.toListing()));
    }

    @Test(expected = InvalidNameException.class)
    public void validate_book_req_throws_error_if_book_not_found_in_list() throws InvalidNameException {
        books.validateBookRequest("The world according to Will");
    }
}
