package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTests {

    private Prompter mockPrompter;
    private Menu menuWithMock;

    @Before
    public void setUpMenuTests() {
        mockPrompter = mock(Prompter.class);
        menuWithMock = new Menu(mockPrompter);
    }

    @Test
    public void list_of_book_shown_when_selected_on_menu() {
        menuWithMock.printSelection("1");
        verify(mockPrompter).printWithNewLine("*** Showing Books ***");
    }

    @Test
    public void cannot_Choose_Invalid_Option() {
        menuWithMock.printSelection("10");
        verify(mockPrompter).printWithNewLine("Please Select a Valid Option!");
    }

    @Test
    public void quit_biblioteca_when_q_input() {
        menuWithMock.printSelection("q");
        verify(mockPrompter).printWithNewLine("*** Thanks for using Biblioteca ***");
    }

    @Test
    public void callsCheckoutBookFunction() {
        menuWithMock.printSelection("2");
        verify(mockPrompter).print("Enter name of Book: ");
    }
}