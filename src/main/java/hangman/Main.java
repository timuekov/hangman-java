package hangman;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    private static final String FILE_PATH = "/words.txt";
    private static final int MIN_WORD_LENGTH = 5;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordDictionary wordDictionary;


        try {
            wordDictionary = new WordDictionary(FILE_PATH, MIN_WORD_LENGTH);

        } catch (IOException e) {
            System.out.println("Не удалось загрузить словарь. Игра не может быть запущена!");
            return;
        }


        GameController gameController = new GameController(scanner, wordDictionary);
        gameController.run();

    }

}


