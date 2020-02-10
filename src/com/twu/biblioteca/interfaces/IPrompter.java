package com.twu.biblioteca.interfaces;

public interface IPrompter {
    void printWithNewLine(String message);

    void print(String message);

    String readInput();

    String readPassword();
}
