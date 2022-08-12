package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDisplay {

    private static final Scanner scannerObj = new Scanner(System.in);
    private static String hiddenWord = "";
    private static String guessLetter;

    // setters
    public static void setHiddenWord(String newHiddenWord) {
        hiddenWord = newHiddenWord;
    }

    public static void generateUnderscores() {
        hiddenWord += "_";
    }

    public static void setGuessLetter(String guess) {
        guessLetter = guess;
    }

    // getters
    public static String getHiddenWord() {
        return hiddenWord;
    }

    public static String getGuessLetter() {
        return guessLetter;
    }

    // methods
    public static void askUserForLetter() {
        System.out.println("Let's guess a letter: ");
        String letter = scannerObj.nextLine();

        // validate user's input
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(letter);
        boolean matchFound = matcher.find();

        if (letter.length() != 1 || matchFound) {
            System.out.println("Please guess a letter only");
        }

        setGuessLetter(letter);
    }

    public static void replaceUnderscore(String rightLetter, int index) {
        StringBuilder newHiddenWord = new StringBuilder(getHiddenWord());
        newHiddenWord.setCharAt(index, rightLetter.charAt(0));
        setHiddenWord(newHiddenWord.toString());
    }


}
