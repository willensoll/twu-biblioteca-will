package com.twu.biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Prompter prompter = new Prompter(System.out, new Scanner(System.in));
        Menu menu = new Menu(prompter);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(prompter, menu);

        bibliotecaApp.start();
    }
}
