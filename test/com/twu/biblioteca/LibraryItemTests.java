package com.twu.biblioteca;

import com.twu.biblioteca.classes.LibraryItem;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryItemTests {

    private LibraryItem testLibraryItem;

    @Before
    public void initBook() {
        testLibraryItem = new LibraryItem("Catcher in the Rye", "J D Salinger", 1951);
    }

    @Test
    public void libraryItem_has_name_value() {
        assertThat(testLibraryItem.getName(), is("Catcher in the Rye"));
    }

    @Test
    public void libraryItem_has_author_value() {
        assertThat(testLibraryItem.getAuthor(), is("J D Salinger"));
    }

    @Test
    public void libraryItem_has_publishedDate_value() {
        assertThat(testLibraryItem.getPublishYear(), is(1951));
    }
}
