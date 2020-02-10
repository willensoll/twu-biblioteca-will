package com.twu.biblioteca.classes;
import com.twu.biblioteca.interfaces.IPrompter;
import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class UserLogin {

    private IPrompter _prompter;
    public ArrayList<User> _userList;

    public UserLogin(IPrompter prompter, ArrayList userList) {
        _prompter = prompter;
        _userList = userList;
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
                user.login();
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
        return _prompter.readPassword();
    }
}
