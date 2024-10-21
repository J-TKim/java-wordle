package wordle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordTest {

    @Test
    void testConvertAnswerToColorTileCase1() {
        String answer = "hello";
        String guess = "lolal";
        Word word = new Word(answer);
        String converted = word.convertAnswerToColorTile(guess);
        assertEquals("🟨🟨🟩⬜⬜", converted);
    }

    @Test
    void testConvertAnswerToColorTileCase2() {
        String answer = "apple";
        String guess = "hello";
        Word word = new Word(answer);
        String converted = word.convertAnswerToColorTile(guess);
        assertEquals("⬜🟨⬜🟩⬜", converted);
    }

    @Test
    void testCheckWordIsValid() {
        Word word = new Word();
        assertTrue(word.checkWordIsValid("apple"));
    }

}