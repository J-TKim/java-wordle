package wordle;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Game(Word.getAnswer());
    }
}
