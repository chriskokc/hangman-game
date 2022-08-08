import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    // variables
    private int userLife;
    private ArrayList<String> words = new ArrayList<>();
    private String hiddenWords = "";
    private String pickedWord;

    // constructors
    public GameLogic() {
        this.setUserLife(0);
        this.generateWords();
    }

    // setters
    public void setUserLife(int userLife) {
        this.userLife = userLife;
    }

    public void generateWords() {
        this.words.add("Motivation");
        this.words.add("Java");
        this.words.add("Coding");
        this.words.add("Programming");
        this.words.add("Fun");
        this.words.add("Foodie");
        this.words.add("Computer");
        this.words.add("Air");
        this.words.add("Housekeeper");
        this.words.add("Bee");
    }

    // methods
    public void pickRandomWord() {
        Random randomObj = new Random();
        int randomIndex = randomObj.nextInt(this.words.size());
        this.pickedWord = words.get(randomIndex);
    }

    public void getUnderScores() {
        for (int i=0; i < this.pickedWord.length(); i++) {
            this.hiddenWords += "_ ";
        }
    }

    public boolean isInWord(String userInputLetter) {
        return this.pickedWord.toLowerCase().contains(userInputLetter.toLowerCase());
    }

    public static void main(String[] args) {
        GameLogic hangman = new GameLogic();
        hangman.pickRandomWord();
        hangman.getUnderScores();
        System.out.println(hangman.words);
        System.out.println(hangman.pickedWord);
        System.out.println(hangman.hiddenWords);
    }

}
