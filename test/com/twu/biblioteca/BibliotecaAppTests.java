package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTests {

    private BibliotecaApp bibliotecaApp;
    private Prompter mockPrompter;
    private Menu mockMenu;

    @Before
    public void setUpAppTests() {
        mockPrompter = mock(Prompter.class);
        mockMenu = mock(Menu.class);
        bibliotecaApp = new BibliotecaApp(mockPrompter, mockMenu);
    }

    @Test
    public void Welcome_message_displays_on_init() {
        bibliotecaApp.start();
        verify(mockPrompter).printWithNewLine("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void Should_show_menu_on_init() {
        bibliotecaApp.start();
        verify(mockMenu).initMenu();
    }

}
