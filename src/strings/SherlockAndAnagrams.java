// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(numberOfAnagrammaticPairs(string));
        }
    }

    private static int numberOfAnagrammaticPairs(String string) {
        Map<Map<Character, Integer>, Integer> frequencyDistribution = getFrequenciesOfSubstrings(string);
        int anagrammaticPairs = 0;
        for (int frequency : frequencyDistribution.values()) {
            anagrammaticPairs += (frequency * (frequency - 1)) / 2;
        }
        return anagrammaticPairs;
    }

    private static Map<Map<Character, Integer>, Integer> getFrequenciesOfSubstrings(String string) {
        Map<Map<Character, Integer>, Integer> frequencies = new HashMap<>();
        char[] array = string.toCharArray();
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i + 1 ; j <= array.length ; j++) {
                Map<Character, Integer> signature = getFrequency(array, i, j);
                frequencies.put(signature, frequencies.getOrDefault(signature, 0) + 1);
            }
        }
        return frequencies;
    }

    private static Map<Character, Integer> getFrequency(char[] array, int start, int end) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int index = start ; index < end ; index++) {
            char character = array[index];
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }
        return frequency;
    }
}
