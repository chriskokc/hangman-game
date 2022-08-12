package controller;

import model.GameLogic;
import view.InputDisplay;
import view.OutputDisplay;

public class Mediator {

    // methods
    public static void playGame() {
        GameLogic hangman = new GameLogic();
        InputDisplay inputDisplay = new InputDisplay();

        hangman.pickRandomWord();
        System.out.println("The picked word is: " + hangman.getPickedWord());
        OutputDisplay.welcomeUser();

        for (int i = 0; i < hangman.getPickedWord().length(); i++) {
            inputDisplay.generateUnderscores();
        }

        OutputDisplay.showGameLogo();

        boolean isGameOver = false;

        while (!isGameOver) {

            inputDisplay.drawHangman(inputDisplay.getCurrentDrawing());
            System.out.println(inputDisplay.getHiddenWord());
            inputDisplay.askUserForLetter();

            // if guess letter is in the word
            if (hangman.isInWord(inputDisplay.getGuessLetter()) && !inputDisplay.getHiddenWord().contains(inputDisplay.getGuessLetter())) {
                int index = hangman.getPickedWord().toLowerCase().indexOf(inputDisplay.getGuessLetter().toLowerCase());
                while (index >= 0) {
                    inputDisplay.replaceUnderscore(inputDisplay.getGuessLetter(), index);
                    index = hangman.getPickedWord().toLowerCase().indexOf(inputDisplay.getGuessLetter().toLowerCase(), index+1);
                }

                // if all underscores have been replaced
                if (!inputDisplay.getHiddenWord().contains("_")) {
                    System.out.println("Congratulations you win!");
                    System.out.println("The answer is: " + hangman.getPickedWord());
                    isGameOver = true;
                }

            } else {
                // draw a hangman
                inputDisplay.addingState(inputDisplay.getDrawingState());

                if (inputDisplay.getDrawingState() == 13) {
                    inputDisplay.drawHangman(inputDisplay.getCurrentDrawing());
                    System.out.println("You run out of life unfortunately :(");
                    System.out.println("The answer is: " + hangman.getPickedWord());
                    isGameOver = true;
                }
            }

        }

    }
}
