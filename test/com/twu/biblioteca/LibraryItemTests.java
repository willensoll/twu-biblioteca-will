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

    @Test
    public void libraryItem_has_isAvailableBool_default_to_true() {
        assertThat(testLibraryItem.getAvailable(), is(true));
    }

    @Test
    public void libraryItem_has_checkedOutBy_string() {
        testLibraryItem.setCheckedOutBy("will");
        assertThat(testLibraryItem.getCheckedOutBy(), is("will"));
    }

    @Test
    public void toListing_returns_book_in_correct_format() {
        String test = testLibraryItem.toListing();
        assertThat(test, is("Catcher in the Rye | J D Salinger | 1951"));
    }

}