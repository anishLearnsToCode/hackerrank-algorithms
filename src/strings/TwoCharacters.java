// https://www.hackerrank.com/challenges/two-characters/problem

package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TwoCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String string = scanner.next();
        System.out.println(longestAlternatingSequence(string));
    }

    private static int longestAlternatingSequence(String string) {
        Map<Character, List<Integer>> indices = getIndices(string);
        List<Character> uniqueElements = getUniqueCharacters(string);
        int result = 0;

        for (int i = 0 ; i < uniqueElements.size() - 1 ; i++) {
            for (int j = i + 1 ; j < uniqueElements.size() ; j++) {
                List<Integer> sequence1 = indices.get(uniqueElements.get(i));
                List<Integer> sequence2 = indices.get(uniqueElements.get(j));
                if (isAlternating(sequence1, sequence2)) {
                    result = Math.max(result, sequence1.size() + sequence2.size());
                    if (result == 9) {
                        System.out.println(uniqueElements.get(i));
                        System.out.println(uniqueElements.get(j));
                    }
                }
            }
        }

        return result;
    }

    private static boolean isAlternating(List<Integer> sequence1, List<Integer> sequence2) {
        List<Integer> greaterSequence = sequence1.get(0) > sequence2.get(0) ? sequence1 : sequence2;
        List<Integer> smallerSequence = sequence1.get(0) > sequence2.get(0) ? sequence2 : sequence1;

        if (greaterSequence.size() > smallerSequence.size() || greaterSequence.size() - smallerSequence.size() < -1
            || smallerSequence.size() - greaterSequence.size() > 1) {
            return false;
        }

        for (int index = 1 ; index < sequence1.size() && index < sequence2.size() ; index++) {
            int alternating = greaterSequence.get(index) - smallerSequence.get(index);
            int previousChecker = smallerSequence.get(index) - greaterSequence.get(index - 1);
            if (alternating * previousChecker < 0) {
                return false;
            }
        }

        if (smallerSequence.size() > greaterSequence.size()) {
            return smallerSequence.get(smallerSequence.size() - 1) > greaterSequence.get(greaterSequence.size() - 1);
        }

        return true;
    }

    private static Map<Character, List<Integer>> getIndices(String string) {
        Map<Character, List<Integer>> indices = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            List<Integer> sequence = indices.getOrDefault(character, new ArrayList<>());
            sequence.add(index);
            indices.put(character, sequence);
        }
        return indices;
    }

    private static List<Character> getUniqueCharacters(String string) {
        Set<Character> visited = new HashSet<>();
        List<Character> result = new ArrayList<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (visited.contains(character)) {
                continue;
            }
            visited.add(character);
            result.add(character);
        }
        return result;
    }
}
