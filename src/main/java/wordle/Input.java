package wordle;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputLine() {
        return scanner.nextLine();
    }
}
