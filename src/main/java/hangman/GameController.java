package hangman;

import java.util.Scanner;

public class GameController {

    private static final int START_NEW_GAME = 1;
    private static final int EXIT_PROGRAM = 2;


    private final Scanner scanner;
    private final WordDictionary wordDictionary;

    public GameController(Scanner scanner, WordDictionary wordDictionary) {
        this.scanner = scanner;
        this.wordDictionary = wordDictionary;

    }

    public void run() {

        while (true) {
            System.out.printf("%d — Новая игра, %d — выход%n", START_NEW_GAME, EXIT_PROGRAM);

            if (!scanner.hasNextInt()) {
                System.out.printf("Неверный ввод! Введите %d или %d%n", START_NEW_GAME, EXIT_PROGRAM);
                scanner.nextLine();
                continue;
            }

            int input = scanner.nextInt();

            scanner.nextLine();

            if (input != START_NEW_GAME && input != EXIT_PROGRAM) {
                System.out.println("Неверный ввод!");
                continue;
            }
            if (input == EXIT_PROGRAM) {
                System.out.println("Игра завершена.");
                break;
            }
            runGame();

        }

    }

    private void runGame() {
        String word = wordDictionary.getRandomWord();
        GameSession session = new GameSession(word);

        while (!session.isGameOver()) {

            showGameState(session);

            char letter = readRussianLetter();
            boolean correct = session.isLetterInWord(letter);
            session.registerGuess(letter);

            if (correct) {
                System.out.println("Верно!");
            } else {
                System.out.println("Неверно!");
            }
        }
        showGameState(session);
        if (session.isWon()) {
            System.out.printf("Победа! Правильный ответ: %s%n", session.getWord());
        } else {
            System.out.printf("Поражение! Правильный ответ: %s%n", session.getWord());
        }
    }

    private char readRussianLetter() {
        while (true) {
            String input = scanner.nextLine();


            if (input.length() != 1) {
                System.out.println("Неверный ввод");
                continue;
            }

            if (!Character.isLetter(input.charAt(0))) {
                System.out.println("Неверный ввод! Введите букву.");
                continue;
            }

            char result = input.toLowerCase().charAt(0);

            if ((result < 'а' || result > 'я') && result != 'ё') {
                System.out.println("Введите кириллический символ!");
                continue;
            }

            return result;
        }
    }

    private void showGameState(GameSession session) {
        System.out.println(session.getMaskedWord());
        System.out.println(HangmanArt.getArt(session.getMistakesCount()));
        System.out.printf("Ошибок: %d из %d%n", session.getMistakesCount(), GameSession.MAX_MISTAKES);
        System.out.printf("Уже введённые буквы: %s%n", session.getAllTypedLetters());
    }

}
