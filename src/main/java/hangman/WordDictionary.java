package hangman;

import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class WordDictionary {
    private List<String> words = new ArrayList<>();
    private Random random = new Random();


    public WordDictionary(String dictionaryPath, int minWordLength) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(dictionaryPath);

        if (inputStream == null) {
            throw new IOException("Dictionary file not found");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() >= minWordLength) {
                    words.add(line);
                }
            }
        }
    }

    public String getRandomWord() {
        int size = words.size();
        int randomIndex = random.nextInt(size);
        return words.get(randomIndex);


    }


}



