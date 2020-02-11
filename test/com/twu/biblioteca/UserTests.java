package com.twu.biblioteca;
import com.twu.biblioteca.classes.User;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTests {

    private User _user;

    @Before
    public void setUp() {
            _user = new User("123-4567", "password");
    }

    @Test
    public void user_has_libraryNumber_string() {
        assertThat(_user.getLibraryNumber(), is("123-4567"));
    }

    @Test
    public void user_has_password_String() {
        assertThat(_user.getPassword(), is("password"));
    }
}
