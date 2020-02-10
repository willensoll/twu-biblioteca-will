package com.twu.biblioteca;

import com.twu.biblioteca.classes.Book;
import com.twu.biblioteca.classes.ReturnItem;
import com.twu.biblioteca.classes.LibraryItem;
import com.twu.biblioteca.classes.Prompter;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnItemTests {

    private ReturnItem returnItem;
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
        returnItem = new ReturnItem(IPrompterMock, bookList, "book");
    }


    @Test
    public void successful_return_prints_correct_messages() {
        returnItem.amendItemAvailabilityAfterCheckout(testBook);
        when(IPrompterMock.readInput()).thenReturn("Catcher in the rye");
        returnItem.returnItem();
        verify(IPrompterMock).printWithNewLine("Thank you for returning the book");
    }

    @Test
    public void unsuccessful_return_prints_correct_messages() {
        when(IPrompterMock.readInput()).thenReturn("Will");
        returnItem.returnItem();
        verify(IPrompterMock).printWithNewLine("*** That is not a valid book to return ***");
    }
}