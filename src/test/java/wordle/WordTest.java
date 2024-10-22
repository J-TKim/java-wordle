package wordle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testConvertAnswerToColorTileCase3() {
        String answer = "abcde";
        String guess = "abcde";
        Word word = new Word(answer);
        String converted = word.convertAnswerToColorTile(guess);
        assertEquals("🟩🟩🟩🟩🟩", converted);
    }

    @Test
    void testConvertAnswerToColorTileCase4() {
        String answer = "aaaal";
        String guess = "lllll";
        Word word = new Word(answer);
        String converted = word.convertAnswerToColorTile(guess);
        assertEquals("⬜⬜⬜⬜🟩", converted);
    }

    @Test
    void testCheckWordIsValid() {
        Word word = new Word();
        assertTrue(word.checkWordIsValid("apple"));
        assertFalse(word.checkWordIsValid("appl"));
        assertFalse(word.checkWordIsValid("apple2"));
        assertFalse(word.checkWordIsValid("123gdg"));
        assertFalse(word.checkWordIsValid("안녕하세요"));
    }

}