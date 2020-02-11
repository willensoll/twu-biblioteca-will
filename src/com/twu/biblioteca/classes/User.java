package com.twu.biblioteca.classes;

public class User {

    private String LibraryNumber;
    private String Password;
    private String Email;
    private String PhoneNumber;
    private String Name;

    public User(String libraryNumber, String password,String name, String email, String phoneNumber) {
    LibraryNumber = libraryNumber;
    Password = password;
    Email= email;
    PhoneNumber = phoneNumber;
    Name = name;
    }

    public String getLibraryNumber() {
        return LibraryNumber;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() { return Email; }

    public String getPhoneNumber() { return PhoneNumber; }

    public String getDetails () {
        return Name + " | " + Email + " | " + PhoneNumber;
    }

}
