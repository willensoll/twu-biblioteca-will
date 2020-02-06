package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppTests {

    private App app;
    private IPrompter mockIPrompter;
    private IMenu mockIMenu;

    @Before
    public void setUpAppTests() {
        mockIPrompter = mock(Prompter.class);
        mockIMenu = mock(Menu.class);
        app = new App(mockIPrompter, mockIMenu);
    }

    @Test
    public void Welcome_message_displays_on_init() {
        app.start();
        verify(mockIPrompter).printWithNewLine("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void Should_show_menu_on_init() {
        app.start();
        verify(mockIMenu).initMenu();
    }

    @Test
    public void will_print_books_only_if_availiable() {

    }

}
