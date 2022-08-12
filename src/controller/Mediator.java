package controller;

import model.GameLogic;
import view.InputDisplay;
import view.OutputDisplay;

public class Mediator {

    // methods
    public static void playGame() {
        GameLogic hangman = new GameLogic();

        hangman.pickRandomWord();
        System.out.println("Debugging -> The picked word is: " + hangman.getPickedWord());
        OutputDisplay.welcomeUser();

        for (int i = 0; i < hangman.getPickedWord().length(); i++) {
            InputDisplay.generateUnderscores();
        }

        OutputDisplay.showGameLogo();

        boolean isGameOver = false;

        while (!isGameOver) {

            OutputDisplay.drawHangman(OutputDisplay.getCurrentDrawing());
            OutputDisplay.showCurrentGuess();
            InputDisplay.askUserForLetter();

            // if guess letter is in the word
            if (hangman.isInWord(InputDisplay.getGuessLetter()) && !InputDisplay.getHiddenWord().contains(InputDisplay.getGuessLetter())) {
                int index = hangman.getPickedWord().toLowerCase().indexOf(InputDisplay.getGuessLetter().toLowerCase());
                while (index >= 0) {
                    InputDisplay.replaceUnderscore(InputDisplay.getGuessLetter(), index);
                    index = hangman.getPickedWord().toLowerCase().indexOf(InputDisplay.getGuessLetter().toLowerCase(), index + 1);
                }

                // if all underscores have been replaced
                if (!InputDisplay.getHiddenWord().contains("_")) {
                    OutputDisplay.announceResult(true, hangman.getPickedWord());
                    isGameOver = true;
                }

            } else {
                // draw a hangman
                OutputDisplay.addingState(OutputDisplay.getDrawingState());

                // if the whole hangman has been drawn
                if (OutputDisplay.getDrawingState() == 13) {
                    OutputDisplay.drawHangman(OutputDisplay.getCurrentDrawing());
                    OutputDisplay.announceResult(false, hangman.getPickedWord());
                    isGameOver = true;
                }
            }

        }

    }
}
