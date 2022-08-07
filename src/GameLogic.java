import java.util.ArrayList;

public class GameLogic {
    // variables
    private int userLife;
    private ArrayList<String> words = new ArrayList<>();

    // constructors
    public GameLogic() {
        this.userLife = 0;
        this.words.add("motivation");
        this.words.add("Java");
        this.words.add("Coding");
    }

    // setters
    public void setUserLife(int userLife) {
        this.userLife = userLife;
    }

    // methods

    public static void main(String[] args) {
        GameLogic hangman = new GameLogic();
        System.out.println(hangman.words);
    }
}
