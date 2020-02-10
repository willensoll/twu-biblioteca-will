package com.twu.biblioteca.classes;

public class User {

    private Boolean LoggedIn;
    private String LibraryNumber;
    private String Password;


    public User(String libraryNumber, String password) {
    LoggedIn = false;
    LibraryNumber = libraryNumber;
    Password = password;
    }

    public void login() {
        LoggedIn = true;
    }

    public Boolean getLoggedIn() {
        return LoggedIn;
    }

    public String getLibraryNumber() {
        return LibraryNumber;
    }

    public String getPassword() {
        return Password;
    }

}
