package com.twu.biblioteca;

public interface IPrompter {
    void printWithNewLine(String message);

    void print(String message);

    String readInput();
}
