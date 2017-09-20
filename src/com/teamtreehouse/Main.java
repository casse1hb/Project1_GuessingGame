package com.teamtreehouse;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner reader;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Your code here
        //ADMIN
        System.out.println("Welcome to WHATS IN THAT JAR! With your host....GuessBot");
        //item name
        reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Hello Contestant 1, Welcome to the show!\n What is your name?  ");
        String name = reader.next();
        System.out.println("Hello " + name + "! Welcome to the show!");

        System.out.println("Alright " + name + " What are we putting in the jar?" );
        String items = reader.next();
        //max item count
        System.out.println(name + ", What is the maximum number of " + items + " that can fit in the jar?  ");
        int maxNumberOfItems = reader.nextInt();
        //set random number of items in jar
        Random rand = new Random();
        int  randomItemCount = rand.nextInt(maxNumberOfItems) + 1;

        //PLAYER
        System.out.println("Welcome contestant 2, we're excited to have you");
        System.out.println("Alright lets get playing! Can you guess how many " + items + " are in the jar? The jar can hold a miximum of " + maxNumberOfItems + " " + items);

        System.out.println("\nReady to start guessing? Enter a number and press enter to check");
        int guess = reader.nextInt();
        int guessCount = 1;
        //if not guessed right, keep prompting user
        while(guess != randomItemCount){
            String highOrLow = null;
            if(guess > randomItemCount){
                highOrLow = "high";
            }else if(guess < randomItemCount){
                highOrLow = "low";
            }
            System.out.println("Your guess: " + guess + " is " + highOrLow);
            guess = reader.nextInt();
            guessCount++;
        }

        //if guessed right
        if(guess == randomItemCount){
            System.out.println("Congratulations - You guessed it right. There are " + randomItemCount + " " + items + " in the jar. "+ "It took you " + guessCount + " guess(es) to get it right");
            guessCount = 0; //reset guess count
        }






    }

}
