package hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        WordDictionary  wordDictionary = new WordDictionary();



        while (true) {
            System.out.println("1 — Новая игра, 2 — выход");

            int input = scanner.nextInt();

            scanner.nextLine();

            if (input != 1 && input != 2) {
                System.out.println("Неверный ввод!");
                continue;
            }
            if (input == 2) {
                System.out.println("Игра завершена.");
                break;
            }

            String word = wordDictionary.getRandomWord();
            GameSession session = new GameSession(word);

            while (!session.isGameOver()){
                System.out.println(session.getMaskedWord());
                System.out.println(HangmanArt.getArt(session.getMistakesCount()));
                System.out.println("Ошибок: " + session.getMistakesCount() + " из 6");

                char letter = readLetter(scanner);
                boolean correct = session.checkTypedLetter(letter);

                if (correct){
                    System.out.println("Верно!");
                }
                else {
                    System.out.println("Неверно!");
                }


            }

            if(session.isWon()){
                System.out.println("Победа! Правильный ответ: " + session.getWord());
            }
            else {
                System.out.println("Поражение! Правильный ответ: " + session.getWord());
            }



        }

    }
    private static char readLetter(Scanner scanner) {
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
            return input.charAt(0);
        }
    }




}
