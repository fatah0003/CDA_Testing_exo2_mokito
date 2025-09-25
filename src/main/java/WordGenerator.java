import java.util.List;
import java.util.Random;

public class WordGenerator {
    private final List<String> words;
    private final Random random;

    public WordGenerator(List<String> words, Random random) {
        // ...
        this.words = words;
        this.random = random;
    }

    public String getRandomWord() {
        return words.get(random.nextInt(words.size()));
        // ...
    }

    public String getWord(int index) {
        return words.get(index);
        // ...
    }
}
