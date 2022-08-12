
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

        System.out.println(display.getHiddenWord());

        boolean isGameOver = false;

        while (!isGameOver) {
            System.out.println("The current life is: " + hangman.getUserLife());
            display.askUserForLetter();

            // if guess letter is in the word
            if (hangman.isInWord(display.getGuessLetter())) {
                System.out.println("The guess is " + display.getGuessLetter());
                int index = hangman.getPickedWord().toLowerCase().indexOf(display.getGuessLetter().toLowerCase());
                display.replaceUnderscore(display.getGuessLetter(), index);

                // if all underscores have been replaced
                if (!display.getHiddenWord().contains("_")) {
                    System.out.println("Congratulations you win!");
                    isGameOver = true;
                }

            } else {
                // decrease user's life
                hangman.setUserLife(hangman.getUserLife()-1);

                if (hangman.getUserLife() == 0) {
                    System.out.println("You run out of life unfortunately :(");
                    System.out.println("The answer is: " + hangman.getPickedWord());
                    isGameOver = true;
                }
            }

            System.out.println(display.getHiddenWord());

        }

    }
}
