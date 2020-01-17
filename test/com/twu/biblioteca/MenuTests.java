package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class MenuTests {

    private ByteArrayOutputStream outContent;
    private Prompter prompter;
    private Menu menu;


    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUpMenuTests() {
        outContent = new ByteArrayOutputStream();
        prompter = new Prompter(System.out, new Scanner(System.in));
        menu = new Menu(prompter);
    }

    @Test
    public void list_of_book_shown_when_selected_on_menu() {
        System.setOut(new PrintStream(outContent));
        menu.printSelection("1");
        assertThat(outContent.toString(), containsString("*** Showing Books ***"));
    }

    @Test
    public void cannot_Choose_Invalid_Option() {
        outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        menu.printSelection("10");
        assertEquals(
                "Please Select a Valid Option!\n",
                outContent.toString()
        );
    }

    @Test
    public void app_is_quit_when_q_is_chosen() {
        Menu mockMenu = mock(Menu.class);
        menu.printSelection("q");


    }

}
