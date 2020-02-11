package com.twu.biblioteca.classes;
import com.twu.biblioteca.interfaces.IPrompter;
import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class Auth {

    private IPrompter _prompter;
    private Boolean _authenticated;
    private ArrayList<User> _userList;
    private User _authenticatedUser;

    public Auth(IPrompter prompter, ArrayList userList) {
        _prompter = prompter;
        _userList = userList;
        _authenticated = false;
    }

    public void run() {
        try {
             getValidateUserCredentials();
        } catch(InvalidNameException ex) {
            _prompter.printWithNewLine("*** Sorry, those credentials were incorrect ***");
        }
    }

    public User getValidateUserCredentials() throws InvalidNameException {
       String libNum =  getLibraryNumber();
       String pw = getPassword();
        for (User user: _userList) {
            if (libNum.equals(user.getLibraryNumber()) && pw.equals(user.getPassword())) {
                _authenticatedUser = user;
                _authenticated = true;
                return user;
            }
        }
        throw new InvalidNameException();
    }

    public String getLibraryNumber() {
        _prompter.print("Library Number: ");
        return _prompter.readInput();
    }

    public String getPassword() {
        _prompter.print("Password: ");
        return _prompter.readInput();
    }

    public Boolean getAuthenticated() {
        return _authenticated;
    }

    public User getAuthenticatedUser() {
        return _authenticatedUser;
    }

    public String getAuthenticatedUserDetails() {
        return _authenticatedUser.getDetails();
    }
}
