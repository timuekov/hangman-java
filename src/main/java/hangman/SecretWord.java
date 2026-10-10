package hangman;

import java.util.HashSet;
import java.util.Set;

public class SecretWord {

    private final String word;
    private final Set<Character> wordLetters = new HashSet<>();
    private final Set<Character> correctLetters = new HashSet<>();


    public SecretWord(String word) {
        this.word = word;

        for (char letter : word.toCharArray()) {
            wordLetters.add(letter);
        }
    }


    public boolean isWon() {
        return correctLetters.containsAll(wordLetters);


    }

    public boolean isLetterInWord(char letter) {
        return wordLetters.contains(letter);
    }

    public void acceptCorrectLetter(char letter) {
        correctLetters.add(letter);
    }


    public String getMaskedWord() {
        StringBuilder sb = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (correctLetters.contains(letter)) {
                sb.append(letter);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();

    }

    public String getWord() {
        return word;
    }

    public Set<Character> getCorrectLetters() {
        HashSet<Character> hashSet = new HashSet<>(correctLetters);
        return hashSet;
    }
}
