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
    public void logIn_returns_true_when_logged_in() {
        _user.login();
        assertThat(_user.getLoggedIn(), is(true));
    }
}
