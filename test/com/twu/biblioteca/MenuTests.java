package com.twu.biblioteca;

import com.twu.biblioteca.classes.*;
import com.twu.biblioteca.interfaces.IMenu;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTests {

    private IPrompter mockIPrompter;
    private IMenu IMenuWithMock;
    private Auth _auth;

    @Before
    public void setUpMenuTests() {
        mockIPrompter = mock(Prompter.class);
        ArrayList mockList = new ArrayList<LibraryItem>();
        _auth = mock(Auth.class);
        IMenuWithMock = new Menu(mockIPrompter, mockList, mockList, _auth);

    }

    @Test
    public void takes_to_login_prompt() {
        IMenuWithMock.printUnAuthSelection("1");
        verify(_auth).run();
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

    @Test
    public void callsCheckedOutBookList() {
        IMenuWithMock.printSelection("6");
        verify(mockIPrompter).printWithNewLine("*** Showing Checked Out Books ***");
    }

    @Test
    public void callsPrintPersonalDetails() {
        IMenuWithMock.printSelection("7");
        verify(mockIPrompter).printWithNewLine("*** Showing your information ***");
    }
}