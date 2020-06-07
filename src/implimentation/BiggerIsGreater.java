// https://www.hackerrank.com/challenges/bigger-is-greater/problem

package implimentation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(lexicographicallySmallest(string));
        }
    }

    private static String lexicographicallySmallest(String string) {
        StringBuilder result = new StringBuilder();
        Queue<Character> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(string.charAt(string.length() - 1));
        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put(string.charAt(string.length() - 1), 1);

        for (int index = string.length() - 2 ; index >= 0 ; index--) {
            char character = string.charAt(index);
            if (character < maxHeap.peek()) {
                return result.append(string.substring(0, index))
                        .append(smallestString(maxHeap, frequencies, character))
                        .toString();
            }
            maxHeap.add(character);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }

        return "no answer";
    }

    private static StringBuilder smallestString(Queue<Character> maxHeap, Map<Character, Integer> frequencies, char character) {
        StringBuilder result = new StringBuilder();
        char top = '-';
        while (!maxHeap.isEmpty() && character < maxHeap.peek()) {
            top = maxHeap.poll();
        }
        result.append(top);
        frequencies.put(top, frequencies.get(top) - 1);
        frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);

        return result.append(smallestString(frequencies));
    }

    private static StringBuilder smallestString(Map<Character, Integer> frequencies) {
        StringBuilder result = new StringBuilder();
        for (char character = 'a' ; character <= 'z' ; character++) {
            int frequency = frequencies.getOrDefault(character, 0);
            while (frequency-- > 0) {
                result.append(character);
            }
        }
        return result;
    }
}
