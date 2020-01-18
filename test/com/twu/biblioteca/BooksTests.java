package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BooksTests {

    private Books books;
    private Prompter prompterMock;
    private Book testBook;
    private Book testBook2;

    @Before
    public void initBooksTests () {

        prompterMock = mock(Prompter.class);
        ArrayList<Book> booklist = new ArrayList<>();

        testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        testBook2 = new Book("Sum", "David Eagleman", 2009);
        booklist.add(testBook);
        booklist.add(testBook2);
        books = new Books(prompterMock, booklist);

    }

    @Test
    public void books_creates_books_list() {
        ArrayList test = books.getBooks();
        assertThat(2, is(test.size()));    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_list() throws InvalidNameException {
        Book test = books.validateBookRequest("Catcher in the Rye");
        assertThat(test, is(testBook));
    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_list_ignores_case() throws InvalidNameException {
        Book test = books.validateBookRequest("CATCHer in the rYe");
        assertThat(test, is(testBook));
    }

    @Test(expected = InvalidNameException.class)
    public void validate_book_req_throws_error_if_book_not_found_in_list() throws InvalidNameException {
        books.validateBookRequest("The world according to Will");
    }

    @Test
    public void checkedOut_list_starts_at_0() {
        assertThat(books.checkedOutBookList.size(), is(0));
    }

    @Test
    public void checkout_book_removes_book_from_available_list() {
        books.amendBookAvailability(testBook);
        assertThat(books.availableBookList.size(), is(1));
    }

    @Test
    public void checkout_book_adds_book_to_checkedOut_list() {
        books.amendBookAvailability(testBook);
        assertThat(books.checkedOutBookList.size(), is(1));
    }

    @Test
    public void successful_checkout_prints_correct_messages() {
        when(prompterMock.readInput()).thenReturn("Catcher in the rye");
        books.checkOut();
        verify(prompterMock).printWithNewLine("Thank you! Enjoy the book");
    }

    @Test
    public void unsuccessful_checkout_prints_correct_messages() {
        when(prompterMock.readInput()).thenReturn("Will");
        books.checkOut();
        verify(prompterMock).printWithNewLine("*** Sorry, that book is not available ***");
    }
}
