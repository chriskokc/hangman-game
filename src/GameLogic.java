import java.util.ArrayList;

public class GameLogic {
    // variables
    private int userLife;
    private ArrayList<String> words = new ArrayList<>();
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
        int index = (int) (Math.random() * this.words.size());
        this.pickedWord = words.get(index);
    }

    public boolean isInWord(String userInputLetter) {
        return this.pickedWord.toLowerCase().contains(userInputLetter.toLowerCase());
    }

}
