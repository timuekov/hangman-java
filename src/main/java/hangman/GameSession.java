package hangman;

import java.util.HashSet;
import java.util.Set;

public class GameSession {
    private String word;

    private Set<Character> wordLetters = new HashSet<>();
    private Set<Character> correctLetters = new HashSet<>();
    private Set<Character> wrongLetters = new HashSet<>();


    public GameSession(String word){
        this.word = word;
        for (char letter: word.toCharArray()){
            wordLetters.add(letter);
        }
    }

    public boolean checkTypedLetter( char letter) {
        if (correctLetters.contains(letter) || wrongLetters.contains(letter)) {
            return correctLetters.contains(letter);
        }
        if (wordLetters.contains(letter)) {

            correctLetters.add(letter);
            return true;
        }
        else {
            wrongLetters.add(letter);
            return false;

        }

    }

    public boolean isWon(){
        return  correctLetters.containsAll(wordLetters);

    }

    public boolean isGameOver(){
        return isWon() || wrongLetters.size() >= 6;
    }


    public int getMistakesCount() {
        return wrongLetters.size();
    }


    public String getMaskedWord(){
        StringBuilder sb = new StringBuilder();
        for (char letter: word.toCharArray()){
            if (correctLetters.contains(letter)){
                sb.append(letter);
            }
            else {
                sb.append('_');
            }
        }
        return sb.toString();

    }

    public String getWord() {
        return word;
    }

}



