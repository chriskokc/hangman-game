
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Display {

    private static final Scanner scannerObj = new Scanner(System.in);
    private String hiddenWord = "";
    private String guessLetter;

    // setters
    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public void generateUnderscores() {
        this.hiddenWord += "_";
    }

    public void setGuessLetter(String guessLetter) {
        this.guessLetter = guessLetter;
    }

    // getters
    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getGuessLetter() {
        return guessLetter;
    }

    // methods
    public void welcomeUser() {
        System.out.println("Welcome to the hangman game!");
        System.out.println("Please guess the following word: ");
    }

    public void askUserForLetter() {
        System.out.println("Let's guess a letter: ");
        String letter = scannerObj.nextLine();

        // validate user's input
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(letter);
        boolean matchFound = matcher.find();

        if (letter.length() != 1 || matchFound) {
            System.out.println("Please guess a letter only");
        }

        this.setGuessLetter(letter);
    }

    public void replaceUnderscore(String rightLetter, int index) {
        StringBuilder newHiddenWord = new StringBuilder(this.getHiddenWord());
        newHiddenWord.setCharAt(index, rightLetter.charAt(0));
        this.setHiddenWord(newHiddenWord.toString());
    }

}
