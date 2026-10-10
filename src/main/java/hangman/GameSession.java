package hangman;

import java.util.HashSet;
import java.util.Set;

public class GameSession {

    private final SecretWord secretWord;

    private final Set<Character> wrongLetters = new HashSet<>();
    public static final int MAX_MISTAKES = 6;


    public GameSession(String word) {
        this.secretWord = new SecretWord(word);
    }

    public Set<Character> getAllTypedLetters() {
        Set<Character> result = new HashSet<>();
        result.addAll(secretWord.getCorrectLetters());
        result.addAll(wrongLetters);
        return result;
    }


    public boolean isLetterInWord(char letter) {

        return secretWord.isLetterInWord(letter);
    }

    public void registerGuess(char letter) {
        if (isLetterInWord(letter)) {
            secretWord.acceptCorrectLetter(letter);
        } else {
            wrongLetters.add(letter);

        }


    }


    public boolean isWon() {
        return secretWord.isWon();

    }

    public boolean isGameOver() {
        return isWon() || wrongLetters.size() >= MAX_MISTAKES;
    }


    public int getMistakesCount() {
        return wrongLetters.size();
    }


    public String getMaskedWord() {

        return secretWord.getMaskedWord();

    }

    public String getWord() {

        return secretWord.getWord();
    }

}



