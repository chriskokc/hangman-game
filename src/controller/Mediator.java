package controller;

import model.GameLogic;
import view.Display;

public class Mediator {

    // methods
    public static void playGame() {
        GameLogic hangman = new GameLogic();
        Display display = new Display();

        hangman.pickRandomWord();
        System.out.println("The picked word is: " + hangman.getPickedWord());
        display.welcomeUser();

        for (int i = 0; i < hangman.getPickedWord().length(); i++) {
            display.generateUnderscores();
        }

        System.out.println("\n" +
                "  _   _                                         \n" +
                " | | | | __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                " | |_| |/ _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                " |  _  | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                " |_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                "                    |___/                       \n");

        boolean isGameOver = false;

        while (!isGameOver) {
            display.drawHangman(display.getCurrentDrawing());
            System.out.println("Please guess the following word: ");
            System.out.println(display.getHiddenWord());

            display.askUserForLetter();

            // if guess letter is in the word
            if (hangman.isInWord(display.getGuessLetter())) {
                int index = hangman.getPickedWord().toLowerCase().indexOf(display.getGuessLetter().toLowerCase());
                while (index >= 0) {
                    display.replaceUnderscore(display.getGuessLetter(), index);
                    index = hangman.getPickedWord().toLowerCase().indexOf(display.getGuessLetter().toLowerCase(), index+1);
                }


                // if all underscores have been replaced
                if (!display.getHiddenWord().contains("_")) {
                    System.out.println("Congratulations you win!");
                    System.out.println("The answer is: " + hangman.getPickedWord());
                    isGameOver = true;
                }

            } else {
                // draw a hangman
                display.addingState(display.getDrawingState());

                if (display.getDrawingState() == 13) {
                    System.out.println("You run out of life unfortunately :(");
                    System.out.println("The answer is: " + hangman.getPickedWord());
                    isGameOver = true;
                }
            }


        }

    }
}
