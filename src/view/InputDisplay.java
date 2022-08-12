package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDisplay {

    private static final Scanner scannerObj = new Scanner(System.in);
    private String hiddenWord = "";
    private String guessLetter;
    private int drawingState = 2;
    private String currentDrawing = "______________\n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            "___|___";

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

    public void setCurrentDrawing(String currentDrawing) {
        this.currentDrawing = currentDrawing;
    }

    public void setDrawingState(int drawingState) {
        this.drawingState = drawingState;
    }

    // getters
    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getGuessLetter() {
        return guessLetter;
    }

    public String getCurrentDrawing() {
        return currentDrawing;
    }

    public int getDrawingState() {
        return drawingState;
    }

    // methods

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

    public void drawHangman(String currentDrawing) {
        System.out.println(currentDrawing);
    }

    public void addingState(int state) {

        String[] drawing = this.getCurrentDrawing().split("\n");

        switch (state) {
            case 8:
                drawing[1] = "   |/      |";
                this.setCurrentDrawing(String.join("\n", drawing));
                this.setDrawingState(state + 1);
                break;
            case 9:
                drawing[2] = "   |      (_)";
                this.setCurrentDrawing(String.join("\n", drawing));
                this.setDrawingState(state + 1);
                break;
            case 10:
                drawing[3] = "   |      \\|/";
                this.setCurrentDrawing(String.join("\n", drawing));
                this.setDrawingState(state + 1);
                break;
            case 11:
                drawing[4] = "   |       |";
                this.setCurrentDrawing(String.join("\n", drawing));
                this.setDrawingState(state + 1);
                break;
            case 12:
                drawing[5] = "   |      / \\";
                this.setCurrentDrawing(String.join("\n", drawing));
                this.setDrawingState(state + 1);
                break;
            default:
                // if state < 8
                drawing[drawing.length - state] = "   |   ";
                this.setCurrentDrawing(String.join("\n", drawing));
                this.setDrawingState(state + 1);
                break;
        }
    }

}
