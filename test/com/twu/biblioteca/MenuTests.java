package com.twu.biblioteca;

import com.twu.biblioteca.classes.Book;
import com.twu.biblioteca.classes.LibraryItem;
import com.twu.biblioteca.classes.Menu;
import com.twu.biblioteca.classes.Prompter;
import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTests {

    private IPrompter mockIPrompter;
    private IMenu IMenuWithMock;

    @Before
    public void setUpMenuTests() {
        mockIPrompter = mock(Prompter.class);
        ArrayList mockList = new ArrayList<LibraryItem>();
        IMenuWithMock = new Menu(mockIPrompter, mockList, mockList);
    }

    @Test
    public void list_of_book_shown_when_selected_on_menu() {
        IMenuWithMock.printSelection("1");
        verify(mockIPrompter).printWithNewLine("*** Showing Books ***");
    }

    @Test
    public void cannot_Choose_Invalid_Option() {
        IMenuWithMock.printSelection("10");
        verify(mockIPrompter).printWithNewLine("Please Select a Valid Option!");
    }

    @Test
    public void quit_biblioteca_when_q_input() {
        IMenuWithMock.printSelection("q");
        verify(mockIPrompter).printWithNewLine("*** Thanks for using Biblioteca ***");
    }

    @Test
    public void callsCheckoutBookFunction() {
        IMenuWithMock.printSelection("2");
        verify(mockIPrompter).print("Enter name of book to borrow: ");
    }

    @Test
    public void callsReturnBookFunction() {
        IMenuWithMock.printSelection("3");
        verify(mockIPrompter).print("Enter name of book to return: ");
    }

    @Test
    public void list_of_movie_shown_when_selected_on_menu() {
        IMenuWithMock.printSelection("4");
        verify(mockIPrompter).printWithNewLine("*** Showing Movies ***");
    }

    @Test
    public void callsCheckoutMovieFunction() {
        IMenuWithMock.printSelection("5");
        verify(mockIPrompter).print("Enter name of movie to borrow: ");
    }
}