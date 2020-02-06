package com.twu.biblioteca;

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
        ArrayList mockBookList = new ArrayList<Book>();
        IMenuWithMock = new Menu(mockIPrompter, mockBookList);
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
        verify(mockIPrompter).print("Enter name of Book to borrow: ");
    }

    @Test
    public void callsReturnBookFunction() {
        IMenuWithMock.printSelection("3");
        verify(mockIPrompter).print("Enter name of Book to return: ");
    }
}