import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HangmanTest {

    private WordGenerator wordGenerator;
    private Hangman hangman;

    @BeforeEach
    void setUp() {
        // Mock de WordGenerator
        wordGenerator = mock(WordGenerator.class);

        // Forcer le mot "java"
        when(wordGenerator.getRandomWord()).thenReturn("java");

        // Créer un Hangman avec 5 tentatives
        hangman = new Hangman(wordGenerator, 5);
    }

    @Test
    void testCorrectGuess() {
        boolean result = hangman.guess('j');
        assertTrue(result);
        assertEquals("j___", hangman.getMaskedWord());
        assertEquals(5, hangman.getRemainingAttempts());
    }

    @Test
    void testIncorrectGuess() {
        boolean result = hangman.guess('z');
        assertFalse(result);
        assertEquals("____", hangman.getMaskedWord());
        assertEquals(4, hangman.getRemainingAttempts());
    }

    @Test
    void testWinGame() {
        hangman.guess('j');
        hangman.guess('a');
        hangman.guess('v');
        assertTrue(hangman.isGameWon());
        assertTrue(hangman.isGameOver());
    }

    @Test
    void testLoseGame() {
        hangman.guess('x');
        hangman.guess('y');
        hangman.guess('z');
        hangman.guess('q');
        hangman.guess('w');
        assertFalse(hangman.isGameWon());
        assertTrue(hangman.isGameOver());
        assertEquals(0, hangman.getRemainingAttempts());
    }
}
