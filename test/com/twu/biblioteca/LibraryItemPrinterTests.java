package com.twu.biblioteca;

import com.twu.biblioteca.classes.Book;
import com.twu.biblioteca.classes.LibraryItemPrinter;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class LibraryItemPrinterTests {

    private Book testBook1;
    private  Book testBook2;
    private IPrompter IPrompterMock;
    ArrayList<Book> bookList;
    private LibraryItemPrinter libraryItemPrinter;

    @Before
    public void initBook() {
        testBook1 = new Book("Catcher in the Rye", "J D Salinger", 1951);
        testBook2 = new Book("Checkout book", "Will Ensoll", 1992);
        IPrompterMock = mock(IPrompter.class);
        bookList = new ArrayList<>();
        bookList.add(testBook1);
        bookList.add(testBook2);
        libraryItemPrinter = new LibraryItemPrinter(IPrompterMock, bookList);
    }

    @Test
    public void printBooks_only_returns_available_books() {
        testBook2.setAvailability(false);
        libraryItemPrinter.run();
        verify(IPrompterMock).printWithNewLine("Catcher in the Rye | J D Salinger | 1951");
        verify(IPrompterMock, atMost(0)).printWithNewLine("Checkout book | Will Ensoll | 1992");
    }
}
