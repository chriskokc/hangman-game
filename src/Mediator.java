
public class Mediator {

    // methods
    public static void playGame() {
        GameLogic hangman = new GameLogic();
        Display display = new Display();

        hangman.pickRandomWord();
        display.welcomeUser();

        for (int i=0; i < hangman.getPickedWord().length(); i++) {
            display.setHiddenWord("_ ");
        }

        System.out.println(display.getHiddenWord());

        display.askUserForLetter();
    }

}
