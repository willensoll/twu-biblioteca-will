package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class Prompter {

    private Scanner sc;
    private PrintStream _outputStream;

    Prompter(PrintStream outputStream, Scanner scanner) {
        sc = scanner;
        _outputStream = outputStream;
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
}
