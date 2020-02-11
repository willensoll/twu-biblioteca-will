package com.twu.biblioteca;

import com.twu.biblioteca.classes.Book;
import com.twu.biblioteca.classes.CheckOutItem;
import com.twu.biblioteca.classes.User;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.mockito.Mockito.*;


public class CheckOutTests {

    private CheckOutItem _checkOutItem;
    private IPrompter IPrompterMock;
    private ArrayList itemList;
    private Book testBook;
    private Book testBook2;
    private User user;


    @Before
    public void setUp() {
        IPrompterMock = mock(IPrompter.class);
        itemList = new ArrayList<>();
        testBook = new Book("Catcher in the Rye", "J D Salinger", 1951);
        testBook2 = new Book("Sum", "David Eagleman", 2009);
        user = new User("libStr", "libNum");
        itemList.add(testBook);
        itemList.add(testBook2);
        _checkOutItem = new CheckOutItem(IPrompterMock, itemList,"book", user);
    }

    @Test
    public void checkoutItem_checks_out_successfuly() {
        when(IPrompterMock.readInput()).thenReturn("Catcher in the rye");
        _checkOutItem.checkOut();
        verify(IPrompterMock).printWithNewLine("Thank you! Enjoy the book");
    }

    @Test
    public void unsuccessful_checkout_prints_correct_messages() {
        when(IPrompterMock.readInput()).thenReturn("Will");
        _checkOutItem.checkOut();
        verify(IPrompterMock).printWithNewLine("*** Sorry, that book is not available ***");
    }
}
