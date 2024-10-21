package wordle;

import java.util.Scanner;


public class Game {
    private static final int maxRound = 6;
    private int round = 1;

    private final String[] playerAnswers = new String[maxRound];
    private boolean isEnd = false;

    private final Word word = new Word();

    public boolean getIsEnd() {
        return isEnd;
    }

    public Game() {
        // Start Game!
        System.out.println("Start Game!");
        for (int i = 0; i < maxRound; i++) {
            round();

            if (getIsEnd()) {
                break;
            }
        }
        System.out.println("End Game!");
    }

    private void round() {

        if (isEnd) {
            return;
        }
        System.out.println("round = " + round);

        String input;
        System.out.print("Input: ");
        while (!word.checkWordIsValid(input = Input.inputLine())) {
            System.out.print("Input again: ");
        }
        final String guess = input;

        playerAnswers[round - 1] = word.convertAnswerToColorTile(guess);
        printMyAnswer();

        if (playerAnswers[round - 1].equals("🟩🟩🟩🟩🟩")) {
            isEnd = true;
            System.out.println("Game is Over. Your win!");
            return;
        }

        if (round >= maxRound) {
            isEnd = true;
            return;
        }
        round++;
    }

    private void printMyAnswer() {
        System.out.println("\nYour answer history.");
        for (String playerAnswer : playerAnswers) {
            if (playerAnswer == null) {
                break;
            }
            System.out.println(playerAnswer);
        }
    }
}
