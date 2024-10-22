package wordle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word {
    private final static int wordLength = 5;
    private final String answer;
    private final Map<Character, Integer> answerLettersMap = new HashMap<>();
    private Map<Character, Integer> copyAnswerLettersMap;

    public Word() {
        this.answer = "apple";
        extractLetters(answer);
    }

    public Word(String answer) {
        checkWordIsValid(answer);
        this.answer = answer;
        extractLetters(answer);
    }

    // Check word is valid
    public boolean checkWordIsValid(String word) {
        if (word.length() != wordLength) {
            return false;
        }
        for (char ch : word.toCharArray()) {
            if (!(ch >= 'a' && ch <= 'z'))

                return false;
        }
        return true;
    }

    private void extractLetters(String answer) {
        for (Character ch : answer.toCharArray()) {
            if (!answerLettersMap.containsKey(ch)) {
                answerLettersMap.put(ch, 0);
            }
            answerLettersMap.put(ch, answerLettersMap.get(ch) + 1);
        }
    }

    public String convertAnswerToColorTile(String playerAnswer) {
        List<TyleColor> tileList = new ArrayList<>(wordLength);

        // Init
        copyAnswerLettersMap = new HashMap<>(this.answerLettersMap);
        for (int i = 0; i < wordLength; i++) {
            tileList.add(TyleColor.NOT_EXIST);
        }

        // Check for green tile
        for (int i = 0; i < wordLength; i++) {
            char answerChar = answer.charAt(i);
            char playerAnswerChar = playerAnswer.charAt(i);

            if (answerChar == playerAnswerChar) {
                reduceLetterCount(playerAnswerChar);
                tileList.remove(i);
                tileList.add(i, TyleColor.CORRECT);
            }
        }

        // Check for yellow tile
        for (int i = 0; i < 5; i++) {
            char answerChar = answer.charAt(i);
            char playerAnswerChar = playerAnswer.charAt(i);

            if (answerChar == playerAnswerChar) {
                continue;
            }
            if (!(copyAnswerLettersMap.containsKey(playerAnswerChar))) {
                continue;
            }
            if (copyAnswerLettersMap.get(playerAnswerChar) <= 0) {
                continue;
            }

            tileList.remove(i);
            tileList.add(i, TyleColor.WRONG_LOCATION);

            reduceLetterCount(playerAnswerChar);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (TyleColor anEnum : tileList) {
            stringBuilder.append(anEnum.getSymbol());
        }
        return String.join("", stringBuilder);
    }

    private void reduceLetterCount(char playerAnswerChar) {
        copyAnswerLettersMap.put(playerAnswerChar, copyAnswerLettersMap.get(playerAnswerChar) - 1);
    }

}
