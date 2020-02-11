package com.twu.biblioteca.classes;

public class User {

    private String LibraryNumber;
    private String Password;


    public User(String libraryNumber, String password) {
    LibraryNumber = libraryNumber;
    Password = password;
    }

    public String getLibraryNumber() {
        return LibraryNumber;
    }

    public String getPassword() {
        return Password;
    }

}
