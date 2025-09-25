import java.util.HashSet;
import java.util.Set;

public class Hangman {
    private final String wordToGuess;
    private final Set<Character> guessedLetters;
    private int remainingAttempts;

    public Hangman(WordGenerator wordGenerator, int maxAttempts) {
        this.wordToGuess = wordGenerator.getRandomWord();
        this.guessedLetters = new HashSet<>();
        this.remainingAttempts = maxAttempts;
    }

    public boolean guess(char letter) {
        return false;
    }

    public String getMaskedWord() {

        return "null";
    }

    public boolean isGameWon() {

        return false;
    }

    public boolean isGameOver() {
        return false;
    }

    public int getRemainingAttempts() {
        return 0;
    }
}
