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
    ArrayList<Book> bookList;

    @Before
    public void initBooksTests () {

        prompterMock = mock(Prompter.class);
        bookList = new ArrayList<>();

        testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        testBook2 = new Book("Sum", "David Eagleman", 2009);
        bookList.add(testBook);
        bookList.add(testBook2);
        books = new Books(prompterMock, bookList);

    }

    @Test
    public void books_creates_books_list() {
        ArrayList test = books.getBooks();
        assertThat(2, is(test.size()));    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_available_list() throws InvalidNameException {
        Book test = books.validateBookRequest("Catcher in the Rye", books.availableBookList);
        assertThat(test, is(testBook));
    }


    @Test
    public void validate_book_req_returns_true_if_book_found_in_checkedOut_list() throws InvalidNameException {
        books.amendBookAvailabilityAfterCheckout(testBook);
        Book test = books.validateBookRequest("Catcher in the Rye", books.checkedOutBookList);
        assertThat(test, is(testBook));
    }

    @Test
    public void validate_book_req_returns_true_if_book_found_in_list_ignores_case() throws InvalidNameException {
        Book test = books.validateBookRequest("CATCHer in the rYe", books.availableBookList);
        assertThat(test, is(testBook));
    }

    @Test(expected = InvalidNameException.class)
    public void validate_book_req_throws_error_if_book_not_found_in_list() throws InvalidNameException {
        books.validateBookRequest("The world according to Will", books.availableBookList);
    }

    @Test
    public void checkedOut_list_starts_at_0() {
        assertThat(books.checkedOutBookList.size(), is(0));
    }

    @Test
    public void checkout_book_removes_book_from_available_list() {
        books.amendBookAvailabilityAfterCheckout(testBook);
        assertThat(books.availableBookList.size(), is(1));
    }

    @Test
    public void checkout_book_adds_book_to_checkedOut_list() {
        books.amendBookAvailabilityAfterCheckout(testBook);
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

    @Test
    public void return_book_removes_book_from_checkedOut_list()
    {
        books.amendBookAvailabilityAfterCheckout(testBook);
        assertThat(books.availableBookList.size(), is(1));
        books.amendBookAvailabilityAfterReturn(testBook);
        assertThat(books.checkedOutBookList.size(), is(0));
    }


    @Test
    public void return_book_removes_book_from_checkedOut_list_and_into_avail_list()
    {
        books.amendBookAvailabilityAfterCheckout(testBook);
        assertThat(books.availableBookList.size(), is(1));
        books.amendBookAvailabilityAfterReturn(testBook);
        assertThat(books.checkedOutBookList.size(), is(0));
        assertThat(books.availableBookList.size(), is(2));

    }

    @Test
    public void successful_return_prints_correct_messages() {
        books.amendBookAvailabilityAfterCheckout(testBook);
        when(prompterMock.readInput()).thenReturn("Catcher in the rye");
        books.returnBooks();
        verify(prompterMock).printWithNewLine("Thank you for returning the book");
    }

    @Test
    public void unsuccessful_return_prints_correct_messages() {
        when(prompterMock.readInput()).thenReturn("Will");
        books.returnBooks();
        verify(prompterMock).printWithNewLine("*** That is not a valid book to return ***");
    }
}
