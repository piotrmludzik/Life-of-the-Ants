package com.codecool.ants.view;

import java.util.Scanner;

public class Keyboard {

    public enum Key {
        ENTER('\n'),
        L('l'),
        H('h'),
        Q('q');

        private final char keyChar;

        Key(char keyChar) {
            this.keyChar = keyChar;
        }

        public char getKeyChar() {
            return keyChar;
        }

        private static Key getKey(char keyChar) {
            for (Key key : Key.values()) {
                if (key.getKeyChar() == keyChar)
                    return key;
            }

            return null;
        }
    }

    public Key getKeyPressed() {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while(true) {
            System.out.print("> ");
            userInput = scanner.nextLine();

            if (userInput.isEmpty())
                return Key.ENTER;
            if (userInput.length() > 1) {
                System.out.println("Enter a one char. For help press 'h'.");
                continue;
            }

            Key keyPressed = Key.getKey(userInput.charAt(0));
            if (keyPressed != null)
                return keyPressed;

            System.out.println("Enter only a valid key. For help press 'h'.");
        }
    }
}
