package com.twu.biblioteca;

import com.twu.biblioteca.classes.*;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class LibraryActionTests {

    private LibraryAction _libraryAction;
    private Book testBook;
    private Book testBook2;
    ArrayList<Book> bookList;

    @Before
    public void initBooksTests () {

        bookList = new ArrayList<>();

        testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        testBook2 = new Book("Sum", "David Eagleman", 2009);
        bookList.add(testBook);
        bookList.add(testBook2);
        _libraryAction = new LibraryAction(bookList);
    }

    @Test
    public void validate_item_req_returns_true_if_book_found_and_available() throws InvalidNameException {
        LibraryItem test = _libraryAction.validateItemRequest("Catcher in the Rye", true);
        assertThat(test, is(testBook));
    }

    @Test
    public void validate_item_req_returns_true_if_book_found_and_available_ignores_case() throws InvalidNameException {
        LibraryItem test = _libraryAction.validateItemRequest("CATCHer in the rYe", true);
        assertThat(test, is(testBook));
    }

    @Test(expected = InvalidNameException.class)
    public void validate_item_req_throws_error_if_book_not_found_in_list() throws InvalidNameException {
        _libraryAction.validateItemRequest("The world according to Will", true);
    }
}
