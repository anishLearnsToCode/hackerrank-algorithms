// https://www.hackerrank.com/challenges/making-anagrams/problem

package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        System.out.println(minimumDeletions(first, second));
    }

    private static int minimumDeletions(String first, String second) {
        Map<Character, Integer> frequencies1 = frequencies(first);
        Map<Character, Integer> frequencies2 = frequencies(second);
        int deletions = 0;
        for (Map.Entry<Character, Integer> entry : frequencies1.entrySet()) {
            deletions += Math.abs(entry.getValue() - frequencies2.getOrDefault(entry.getKey(), 0));
        }
        for (Map.Entry<Character, Integer> entry : frequencies2.entrySet()) {
            if (frequencies1.containsKey(entry.getKey())) {
                continue;
            }
            deletions += entry.getValue();
        }

        return deletions;
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
