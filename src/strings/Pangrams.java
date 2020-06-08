// https://www.hackerrank.com/challenges/pangrams/problem

package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(isPangram(string) ? "pangram" : "not pangram");
    }

    private static boolean isPangram(String string) {
        Set<Character> letters = getLetters(string);
        return letters.size() == 26;
    }

    private static Set<Character> getLetters(String string) {
        Set<Character> letters = new HashSet<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (Character.isAlphabetic(character) && character != ' ') {
                letters.add(Character.toLowerCase(character));
            }
        }
        return letters;
    }
}
