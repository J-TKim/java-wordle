package wordle;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private final int maxRound = 6;
    private int round = 1;
    private final String answer;
    private Set<Character> answerLetters = new HashSet<>();
    private String[] playerAnswers = new String[maxRound];
    private boolean isEnd = false;


    public Game(String answer) {
        this.answer = answer;
        setAnswerLetters(answer);

        System.out.println("answer = " + answer + "-- For debug --"); // For debug

        // Start Game!
        System.out.println("Start Game!");
        for (int i = 0; i < 5; i++) {
            round();
        }
    }

    private void setAnswerLetters(String answer) {
        for (char ch : answer.toCharArray()) {
            answerLetters.add(ch);
        }
    }

    private void round() {

        if (isEnd) {
            return;
        }

        System.out.println("round = " + round);

        Scanner scanner = new Scanner(System.in);
        String guess;
        do {
            System.out.print("Input 5 length word : ");
            guess = scanner.nextLine();
        } while (guess.length() != 5);

        playerAnswers[round-1] = guess;
        printMyAnswer();

        if (isCorrectAnswer(guess)) {
            isEnd = true;
            System.out.println("Game is Over. Your win!");
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
                continue;
            }
            System.out.print(convertAnswerToColorSquare(playerAnswer) + " : ");
            System.out.println("playerAnswer = " + playerAnswer);
        }
    }

    private String convertAnswerToColorSquare(String playerAnswer) {
        StringBuilder colorSquare = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char answerChar = answer.charAt(i);
            char playerAnswerChar = playerAnswer.charAt(i);

            if (answerChar == playerAnswerChar) {
                colorSquare.append("🟩");
                continue;
            }
            if (answerLetters.contains(playerAnswerChar)) {
                colorSquare.append("🟨");
                continue;
            }
            colorSquare.append("⬜");
        }
        return colorSquare.toString();
    }

    private boolean isCorrectAnswer(String guess) {
        return answer.equals(guess);
    }
}
