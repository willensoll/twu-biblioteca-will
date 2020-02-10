package com.twu.biblioteca;

import com.twu.biblioteca.classes.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryItemActionTests {

    private LibraryItemAction _libraryItemAction;
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
        _libraryItemAction = new LibraryItemAction(bookList);
    }

    @Test
    public void validate_item_req_returns_true_if_book_found_and_available() throws InvalidNameException {
        LibraryItem test = _libraryItemAction.validateItemRequest("Catcher in the Rye", true);
        assertThat(test, is(testBook));
    }

    @Test
    public void validate_item_req_returns_true_if_book_found_and_available_ignores_case() throws InvalidNameException {
        LibraryItem test = _libraryItemAction.validateItemRequest("CATCHer in the rYe", true);
        assertThat(test, is(testBook));
    }

    @Test(expected = InvalidNameException.class)
    public void validate_item_req_throws_error_if_book_not_found_in_list() throws InvalidNameException {
        _libraryItemAction.validateItemRequest("The world according to Will", true);
    }

    @Test
    public void checkout_sets_item_avail_to_false() {
        _libraryItemAction.amendItemAvailabilityAfterCheckout(testBook);
        assertThat(testBook.getAvailable(), is(false));
    }

    @Test
    public void return_item_sets_avail_to_true() {
        _libraryItemAction.amendItemAvailabilityAfterCheckout(testBook);
        assertThat(testBook.getAvailable(), is(false));
        _libraryItemAction.amendItemAvailabilityAfterReturn(testBook);
        assertThat(testBook.getAvailable(), is(true));
    }
}
