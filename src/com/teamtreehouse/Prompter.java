package com.teamtreehouse;

import java.util.Scanner;

public class Prompter {
    private final Scanner scanner;
    private Jar mJar;
    private int mGuesses;

    public Prompter(Scanner scan) {
        scanner = scan;
    }

    public void printAdminScreen() {
        // clear screen http://stackoverflow.com/questions/2979383/java-clear-the-console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("WELCOME TO 'WHATS IN THAT JAR?!'");
        System.out.println("====================");
    }

    public void setJar() {
        System.out.printf("Alright contestant #1. Welcome to the show. Now lets get started! %n" +
                          "What are we putting in the jar? ");
        String itemName = scanner.nextLine();
        System.out.printf("%s that is very interesting. What is the number of %s that can fit in the jar: ", itemName);
        String capacityString = scanner.nextLine();
        itemName = itemName.toLowerCase();
        int capacity = Integer.parseInt(capacityString);
        mJar = new Jar(itemName, capacity);
        mJar.fill();
        mGuesses = 0;
    }

    public void titleScreen() {
        System.out.println();
        System.out.println("Welcome contestant #2");
        System.out.println("====================");
        System.out.printf("%nYou know the name of the game so lets get started. %s are in the jar.", mJar.getName());
        System.out.printf("%nYour guess should be between 1 and %s.", mJar.getCapacity());
        System.out.println(" ");
        System.out.printf("Ready? (press ENTER to start guessing)");
        scanner.nextLine();
    }

    private int getGuess() {
        int guess;
        boolean in = false;

        do {
            if(in) {
                System.out.println("Try again for free, that's outside of the range!");
            } else {
                in = true;
            }

            guess = 0;
            System.out.printf("%nGuess: ");
            String guessString = scanner.nextLine();
            try {
                guess = Integer.parseInt(guessString);
            } catch (NumberFormatException nfe) {
                System.out.println("Oops!");
            }

        } while (guess > mJar.getCapacity() || guess < 1);

        return mJar.isCount(guess);
    }

    public void makeGuess() {
        int result = getGuess();
        mGuesses++;

        if(result > 0) {
            System.out.println("Too High!");
        } else if (result < 0) {
            System.out.println("Too Low!");
        }

        if(result != 0) {
            makeGuess();
        }
    }

    public boolean win() {
        System.out.printf("%nCongrats! You guessed that there are %s %s in the jar!",
                mJar.getCount(), mJar.getName());
        System.out.printf("%nIt took you %s guess(es) to get it right.",
                mGuesses);
        System.out.println();
        System.out.println("Play Again? (y/n)");
        String again = scanner.nextLine();
        return again.toLowerCase().charAt(0) == 'y';

    }
}