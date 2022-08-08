
import java.util.Scanner;

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
    public void askUserForLetter() {
        System.out.println("Let's guess a letter: ");
        String letter = scannerObj.nextLine();
        System.out.println("Your guess is: " + letter);
    }


}
