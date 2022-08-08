import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    // variables
    private int userLife;
    private ArrayList<String> words = new ArrayList<>();
    private String pickedWord;

    // constructors
    public GameLogic() {
        this.setUserLife(5);
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

    // getters
    public int getUserLife() {
        return userLife;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getPickedWord() {
        return pickedWord;
    }
    // methods
    public void pickRandomWord() {
        Random randomObj = new Random();
        int randomIndex = randomObj.nextInt(this.words.size());
        this.pickedWord = words.get(randomIndex);
    }

    public boolean isInWord(String userInputLetter) {
        return this.pickedWord.toLowerCase().contains(userInputLetter.toLowerCase());
    }


}
