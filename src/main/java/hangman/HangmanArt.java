package hangman;

import java.util.List;

public class HangmanArt {
    private static final List<String> ARTS = List.of(
            """
             +---+
             |   |
                 |
                 |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
                 |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
             |   |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|   |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|\\  |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|\\  |
            /    |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|\\  |
            / \\  |
                 |
            =========
            """
    );

    public static String getArt(int mistakes) {
        return ARTS.get(mistakes);
    }

}