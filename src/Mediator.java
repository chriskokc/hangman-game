
public class Mediator {

    // methods
    public static void playGame() {
        GameLogic hangman = new GameLogic();
        Display display = new Display();

        hangman.pickRandomWord();
        System.out.println(hangman.getPickedWord());

        for (int i=0; i < hangman.getPickedWord().length(); i++) {
            display.setHiddenWord("_ ");
        }

        System.out.println(display.getHiddenWord());
    }

}
