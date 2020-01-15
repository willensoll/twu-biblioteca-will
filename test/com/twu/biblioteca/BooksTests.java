package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BooksTests {

    @Test
    public void books_creates_books_list() {
        Books bookList = new Books();
        ArrayList test = bookList.getBooks();
        assertThat(3, is(test.size()));    }
}
