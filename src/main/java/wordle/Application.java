package wordle;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Start WORDLE game!");

        for (int i = 0; i < 6; i++) {
            System.out.println("Input word: ");
            String guess = scanner.nextLine();

            System.out.println("guess = " + guess);
        }

        System.out.println("Game is over.");
    }
}
