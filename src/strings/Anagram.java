// https://www.hackerrank.com/challenges/anagram/problem

package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(minimumChanges(string));
        }
    }

    private static int minimumChanges(String string) {
        if (string.length() % 2 == 1) {
            return -1;
        }
        String first = string.substring(0, string.length() / 2);
        String second = string.substring(string.length() / 2);
        Map<Character, Integer> frequencies1 = frequencies(first);
        Map<Character, Integer> frequencies2 = frequencies(second);
        int changes = 0;
        for (Map.Entry<Character, Integer> entry : frequencies2.entrySet()) {
            changes += Math.max(
                        entry.getValue() - frequencies1.getOrDefault(entry.getKey(), 0),
                        0
                    );
        }
        return changes;
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
