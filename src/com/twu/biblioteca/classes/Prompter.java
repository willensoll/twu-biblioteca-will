package com.twu.biblioteca.classes;

import com.twu.biblioteca.interfaces.IPrompter;

import java.io.Console;
import java.io.PrintStream;
import java.util.Scanner;

public class Prompter implements IPrompter {

    private Scanner sc;
    private PrintStream _outputStream;
    private Console _console;

    Prompter(PrintStream outputStream, Scanner scanner) {
        sc = scanner;
        _outputStream = outputStream;
        _console = System.console();
    }

    public void printWithNewLine(String message) {
        _outputStream.println(message);
    }

    public void print(String message) {
        _outputStream.print(message);
    }

    public String readInput() {
        String s = sc.nextLine();
        return s;
    }

    public String readPassword() {
        char[] pw = _console.readPassword("Password: ");
        return new String(pw);
    }
}
