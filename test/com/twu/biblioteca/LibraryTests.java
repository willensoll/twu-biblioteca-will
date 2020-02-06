package com.twu.biblioteca;

import com.twu.biblioteca.classes.Book;
import com.twu.biblioteca.classes.Library;
import com.twu.biblioteca.classes.Prompter;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LibraryTests {

    private Library library;
    private IPrompter IPrompterMock;
    private Book testBook;
    private Book testBook2;
    ArrayList<Book> bookList;

    @Before
    public void initBooksTests () {

        IPrompterMock = mock(Prompter.class);
        bookList = new ArrayList<>();

        testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        testBook2 = new Book("Sum", "David Eagleman", 2009);
        bookList.add(testBook);
        bookList.add(testBook2);
        library = new Library(IPrompterMock, bookList);

    }

    @Test
    public void books_creates_books_list() {
        ArrayList test = library.getBooks();
        assertThat(2, is(test.size()));    }

    @Test
    public void validate_book_req_returns_true_if_book_found_and_available() throws InvalidNameException {
        Book test = library.validateBookRequest("Catcher in the Rye", true);
        assertThat(test, is(testBook));
    }

    @Test
    public void validate_book_req_returns_true_if_book_found_and_available_ignores_case() throws InvalidNameException {
        Book test = library.validateBookRequest("CATCHer in the rYe", true);
        assertThat(test, is(testBook));
    }

    @Test(expected = InvalidNameException.class)
    public void validate_book_req_throws_error_if_book_not_found_in_list() throws InvalidNameException {
        library.validateBookRequest("The world according to Will", true);
    }

    @Test(expected = InvalidNameException.class)
    public void validate_book_req_throws_error_if_book_already_checked_out() throws InvalidNameException {
        when(IPrompterMock.readInput()).thenReturn("Catcher in the rye");
        library.checkOut();
        library.validateBookRequest("Catcher in the Rye", true);
    }

    @Test(expected = InvalidNameException.class)
    public void validate_book_req_throws_error_if_book_already_available() throws InvalidNameException {
        when(IPrompterMock.readInput()).thenReturn("Catcher in the rye");
        library.returnBooks();
        library.validateBookRequest("Catcher in the Rye", false);
    }

    @Test
    public void successful_checkout_prints_correct_messages() {
        when(IPrompterMock.readInput()).thenReturn("Catcher in the rye");
        library.checkOut();
        verify(IPrompterMock).printWithNewLine("Thank you! Enjoy the book");
    }

    @Test
    public void unsuccessful_checkout_prints_correct_messages() {
        when(IPrompterMock.readInput()).thenReturn("Will");
        library.checkOut();
        verify(IPrompterMock).printWithNewLine("*** Sorry, that book is not available ***");
    }

    @Test
    public void successful_return_prints_correct_messages() {
        library.amendBookAvailabilityAfterCheckout(testBook);
        when(IPrompterMock.readInput()).thenReturn("Catcher in the rye");
        library.returnBooks();
        verify(IPrompterMock).printWithNewLine("Thank you for returning the book");
    }

    @Test
    public void unsuccessful_return_prints_correct_messages() {
        when(IPrompterMock.readInput()).thenReturn("Will");
        library.returnBooks();
        verify(IPrompterMock).printWithNewLine("*** That is not a valid book to return ***");
    }
}