
public class Mediator {

    // methods
    public static void playGame() {
        GameLogic hangman = new GameLogic();
        Display display = new Display();

        hangman.pickRandomWord();
        System.out.println(hangman.getPickedWord());
        display.welcomeUser();

        for (int i=0; i < hangman.getPickedWord().length(); i++) {
            display.generateUnderscores();
        }

        System.out.println(display.getHiddenWord());

        display.askUserForLetter();

        if (hangman.isInWord(display.getGuessLetter())) {
            System.out.println("The guess is " + display.getGuessLetter());
            int index = hangman.getPickedWord().toLowerCase().indexOf(display.getGuessLetter().toLowerCase());
            System.out.println("Index is " + index);
            display.replaceUnderscore(display.getGuessLetter(), index);
        }

        System.out.println(display.getHiddenWord());
    }

}
