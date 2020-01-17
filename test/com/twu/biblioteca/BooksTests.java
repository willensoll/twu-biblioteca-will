package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BooksTests {

    private Books bookList;

    @Before
    public void initBooksTests () {
        bookList = new Books();

    }

    @Test
    public void books_creates_books_list() {
        ArrayList test = bookList.getBooks();
        assertThat(3, is(test.size()));    }

}
