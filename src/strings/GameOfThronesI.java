// https://www.hackerrank.com/challenges/game-of-thrones/problem

package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThronesI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(canBeMadeIntoPalindrome(string) ? "YES" : "NO");
    }

    private static boolean canBeMadeIntoPalindrome(String string) {
        Map<Character, Integer> frequencies = frequencies(string);
        int oddFrequencies = 0;
        for (int frequency : frequencies.values()) {
            oddFrequencies += frequency % 2 == 1 ? 1 : 0 ;
        }
        return oddFrequencies <= 1;
    }

    private static Map<Character, Integer> frequencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        return frequencies;
    }
}
