package com.twu.biblioteca;

import com.twu.biblioteca.classes.UserLogin;
import com.twu.biblioteca.classes.User;
import com.twu.biblioteca.interfaces.IPrompter;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import javax.naming.InvalidNameException;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserLoginTests {

    private UserLogin _UserLogin;
    private IPrompter IPrompterMock;
    private ArrayList<User> _testUsers;

    @Before
    public void setUp() {
        IPrompterMock = mock(IPrompter.class);
        _testUsers = new ArrayList();
        _testUsers.add(new User("123-4567", "password"));
        _testUsers.add(new User("098-7654", "password"));
        _UserLogin = new UserLogin(IPrompterMock, _testUsers);
    }

    @Test
    public void getLibraryNumber_returns_string() {
        when(IPrompterMock.readInput()).thenReturn("123-4567");
        String libNumTest = _UserLogin.getLibraryNumber();
        assertThat(libNumTest, is("123-4567"));
    }

    @Test
    public void getPassword_returns_String() {
        when(IPrompterMock.readPassword()).thenReturn("password");
        String libPwTest = _UserLogin.getPassword();
        assertThat(libPwTest, is("password"));
    }

    @Test
    public void getValidateUserCredentials_returns_user_when_input_correctly() throws InvalidNameException {
        when(IPrompterMock.readInput()).thenReturn("123-4567");
        when(IPrompterMock.readPassword()).thenReturn("password");
        User user =  _UserLogin.getValidateUserCredentials();
       assertThat(user, is(_testUsers.get(0)));
    }

    @Test(expected = InvalidNameException.class)
    public void getValidateUserCredentials_throws_error_when_input_incorrectly() throws InvalidNameException {
        when(IPrompterMock.readInput()).thenReturn("1234567");
        when(IPrompterMock.readPassword()).thenReturn("password");
        _UserLogin.getValidateUserCredentials();
    }
}
