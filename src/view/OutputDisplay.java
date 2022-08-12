package view;

public class OutputDisplay {

    private static String currentDrawing = "______________\n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            "___|___";
    private static int drawingState = 2;

    // setters
    public static void setCurrentDrawing(String newDrawing) {
        currentDrawing = newDrawing;
    }

    public static void setDrawingState(int newState) {
        drawingState = newState;
    }

    // getters
    public static String getCurrentDrawing() {
        return currentDrawing;
    }

    public static int getDrawingState() {
        return drawingState;
    }

    // methods
    public static void welcomeUser() {
        System.out.println("Welcome to the hangman game!");
    }

    public static void showGameLogo() {
        System.out.println("\n" +
                "  _   _                                         \n" +
                " | | | | __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                " | |_| |/ _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                " |  _  | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                " |_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                "                    |___/                       \n");
    }

    public static void drawHangman(String currentDrawing) {
        System.out.println(currentDrawing);
    }

    public static void addingState(int state) {

        String[] drawing = getCurrentDrawing().split("\n");

        switch (state) {
            case 8:
                drawing[1] = "   |/      |";
                setCurrentDrawing(String.join("\n", drawing));
                setDrawingState(state + 1);
                break;
            case 9:
                drawing[2] = "   |      (_)";
                setCurrentDrawing(String.join("\n", drawing));
                setDrawingState(state + 1);
                break;
            case 10:
                drawing[3] = "   |      \\|/";
                setCurrentDrawing(String.join("\n", drawing));
                setDrawingState(state + 1);
                break;
            case 11:
                drawing[4] = "   |       |";
                setCurrentDrawing(String.join("\n", drawing));
                setDrawingState(state + 1);
                break;
            case 12:
                drawing[5] = "   |      / \\";
                setCurrentDrawing(String.join("\n", drawing));
                setDrawingState(state + 1);
                break;
            default:
                // if state < 8
                drawing[drawing.length - state] = "   |   ";
                setCurrentDrawing(String.join("\n", drawing));
                setDrawingState(state + 1);
                break;
        }
    }

    public static void showCurrentGuess() {
        System.out.println(InputDisplay.getHiddenWord());
    }

    public static void announceResult(boolean isUserWin, String answer) {
        if (isUserWin) {
            System.out.println("Congratulations you win!");
            System.out.println("The answer is: " + answer);
        } else {
            System.out.println("You run out of life unfortunately :(");
            System.out.println("The answer is: " + answer);
        }
    }

}
