// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndTheValidString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(isValidString(string) ? "YES" : "NO");
    }

    private static boolean isValidString(String string) {
        Map<Character, Integer> frequencies = frequencies(string);
        Map<Integer, Integer> distribution = frequencies(frequencies);
        return distribution.size() <= 2
                && greaterThanSignleton(distribution) <= 1
                && (distribution.size() == 1 || singleElementCanBeRemoved(distribution));
    }

    private static boolean singleElementCanBeRemoved(Map<Integer, Integer> distribution) {
        int removalFrequency = removal(distribution);
        int retention = retention(distribution);
        return removalFrequency - 1 == 0 || removalFrequency - 1 == retention;
    }

    private static int removal(Map<Integer, Integer> distribution) {
        for (Map.Entry<Integer, Integer> entry : distribution.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int retention(Map<Integer, Integer> distribution) {
        for (Map.Entry<Integer, Integer> entry : distribution.entrySet()) {
            if (entry.getValue() != 1) {
                return entry.getKey();
            }
        }
        return Integer.MAX_VALUE;
    }

    private static Map<Character, Integer> frequencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        return frequencies;
    }

    private static Map<Integer, Integer> frequencies(Map<Character, Integer> map) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int frequency : map.values()) {
            frequencies.put(frequency, frequencies.getOrDefault(frequency, 0) + 1);
        }
        return frequencies;
    }

    private static int greaterThanSignleton(Map<Integer, Integer> distribution) {
        int counter = 0;
        for (int frequency : distribution.values()) {
            if (frequency > 1) {
                counter++;
            }
        }
        return counter;
    }
}
