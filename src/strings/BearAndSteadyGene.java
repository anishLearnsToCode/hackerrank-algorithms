// https://www.hackerrank.com/challenges/bear-and-steady-gene/problem

package strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String gene = scanner.next();
        System.out.println(minimumModifications(gene));
    }

    private static int minimumModifications(String string) {
        Map<Character, Integer> frequency = getFrequencies(string);
        Map<Character, Integer> extra = extraCharacters(frequency, string.length() / 4);
        int extraCharacters = sum(extra.values());
        if (extraCharacters <= 1) {
            return extraCharacters;
        }
        int minimumSubstringLength = minSubstringLength(extra, string);
        return minimumSubstringLength + 1;
    }

    private static int minSubstringLength(Map<Character, Integer> extra, String string) {
        Map<Character, Integer> current = getStartingSnapshot(extra);
        Map<Map<Character, Integer>, Integer> indices = new HashMap<>();
        indices.put(new HashMap<>(current), -1);
        int minRange = Integer.MAX_VALUE;

        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (extra.containsKey(character)) {
                current.put(character, current.getOrDefault(character, 0) + 1);
            }
            Map<Character, Integer> required = difference(current, extra);
            if (indices.containsKey(required)) {
                minRange = Math.min(minRange, index - indices.get(required) - 1);
            }
            indices.put(new HashMap<>(current), index);
        }

        return minRange;
    }

    private static Map<Character, Integer> getStartingSnapshot(Map<Character, Integer> extra) {
        Map<Character, Integer> result = new HashMap<>();
        for (char character : extra.keySet()) {
            result.put(character, 0);
        }
        return result;
    }

    private static Map<Character, Integer> difference(Map<Character, Integer> current, Map<Character, Integer> extra) {
        Map<Character, Integer> result = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : extra.entrySet()) {
            result.put(entry.getKey(), current.getOrDefault(entry.getKey(), 0) - entry.getValue());
        }
        return result;
    }

    private static int sum(Collection<Integer> set) {
        int sum = 0;
        for (int element : set) {
            sum += element;
        }
        return sum;
    }

    private static Map<Character, Integer> getFrequencies(String string) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }
        return frequency;
    }

    private static Map<Character, Integer> extraCharacters(Map<Character, Integer> frequency, int limit) {
        Map<Character, Integer> result = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > limit) {
                result.put(entry.getKey(), entry.getValue() - limit);
            }
        }
        return result;
    }
}
