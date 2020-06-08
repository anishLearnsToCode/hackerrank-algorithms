// https://www.hackerrank.com/challenges/caesar-cipher-1/problem

package strings;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String string = scanner.next();
        int rotations = scanner.nextInt();
        System.out.println(encrypted(string, rotations));
    }

    private static String encrypted(String string, int rotations) {
        StringBuilder accumulator = new StringBuilder();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            accumulator.append(Character.isAlphabetic(character) ? encrypted(character, rotations) : character);
        }
        return accumulator.toString();
    }

    private static char encrypted(char character, int rotations) {
        if (Character.isLowerCase(character)) {
            return (char) ((character - 97 + rotations) % 26 + 97);
        }
        return (char) ((character - 65 + rotations) % 26 + 65);
    }
}
