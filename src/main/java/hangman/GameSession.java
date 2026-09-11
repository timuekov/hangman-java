package hangman;

import java.util.HashSet;
import java.util.Set;

public class GameSession {
    private String word;

    private Set<Character> wordLetters = new HashSet<>();
    private Set<Character> correctLetters = new HashSet<>();
    private Set<Character> wrongLetters = new HashSet<>();
    public static final int MAX_MISTAKES = 6;


    public GameSession(String word) {
        this.word = word;
        for (char letter : word.toCharArray()) {
            wordLetters.add(letter);
        }
    }

    public Set<Character> getAllTypedLetters() {
        Set<Character> result = new HashSet<>();
        result.addAll(correctLetters);
        result.addAll(wrongLetters);
        return result;
    }


    public boolean isLetterInWord(char letter) {
        return wordLetters.contains(letter);
    }

    public void acceptTypedLetter(char letter) {
        if (isLetterInWord(letter)) {
            correctLetters.add(letter);
        } else {
            wrongLetters.add(letter);

        }

    }


    public boolean isWon() {
        return correctLetters.containsAll(wordLetters);

    }

    public boolean isGameOver() {
        return isWon() || wrongLetters.size() >= MAX_MISTAKES;
    }


    public int getMistakesCount() {
        return wrongLetters.size();
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

}



