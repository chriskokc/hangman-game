
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Display {

    private static final Scanner scannerObj = new Scanner(System.in);
    private String hiddenWord = "";

    // setters
    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord += hiddenWord;
    }

    // getters
    public String getHiddenWord() {
        return hiddenWord;
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
        Pattern pattern = Pattern.compile("[^abc]");
        Matcher matcher = pattern.matcher(letter);
        boolean matchFound = matcher.find();

        if (letter.length() != 1 || matchFound) {
            System.out.println("Please guess a letter only");
        }

        System.out.println("Your guess is: " + letter);
    }

}
