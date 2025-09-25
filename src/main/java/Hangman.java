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
        if (wordToGuess.indexOf(letter) >= 0) {
            guessedLetters.add(letter);
            return true;
        } else {
            remainingAttempts--;
            return false;
        }
    }

    public String getMaskedWord() {
        StringBuilder masked = new StringBuilder();
        for (char c : wordToGuess.toCharArray()) {
            if (guessedLetters.contains(c)) {
                masked.append(c);
            } else {
                masked.append('_');
            }
        }
        return masked.toString();
    }

    public boolean isGameWon() {
        for (char c : wordToGuess.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return remainingAttempts <= 0 || isGameWon();
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }
}
