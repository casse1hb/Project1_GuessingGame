package com.teamtreehouse;

import java.util.Scanner;


public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Prompter prompter = new Prompter(scanner);

        prompter.printAdminScreen();

        boolean again = false;

        do {
            prompter.setJar();
            prompter.titleScreen();
            prompter.makeGuess();
            again = prompter.win();
        } while (again);
        scanner.close();
        System.exit(0);

    }
}