// https://www.hackerrank.com/challenges/camelcase/problem

package strings;

import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println(wordsIn(word));
    }

    private static int wordsIn(String string) {
        int capitalLetters = 0;
        for (int index = 0 ; index < string.length() ; index++) {
            if (isCapital(string.charAt(index))) {
                capitalLetters++;
            }
        }
        return capitalLetters + 1;
    }

    private static boolean isCapital(char character) {
        return Character.isUpperCase(character);
    }
}
