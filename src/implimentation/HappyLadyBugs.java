// https://www.hackerrank.com/challenges/happy-ladybugs/problem

package implimentation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HappyLadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = 1;
        while (queries-- > 0) {
            int length = scanner.nextInt();
            String board = scanner.next();
            System.out.println(isHappy(board) ? "YES" : "NO");
        }
    }

    private static boolean isHappy(String string) {
        Map<Character, Integer> frequencies = getFrequency(string);
        if (containsSingleton(frequencies)) {
            return false;
        } else if (frequencies.containsKey('_')) {
            return true;
        }
        return areContiguous(string);
    }

    private static boolean areContiguous(String string) {
        Set<Character> visited = new HashSet<>();
        char previous = string.charAt(0);
        visited.add(previous);

        for (int index = 1 ; index < string.length() ; index++) {
            char current = string.charAt(index);
            if (visited.contains(current) && current != previous) {
                return false;
            } else if (current != previous) {
                visited.add(current);
                previous = current;
            }
        }

        return true;
    }

    private static boolean containsSingleton(Map<Character, Integer> frequency) {
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getKey() != '_' && entry.getValue() < 2) {
                return true;
            }
        }
        return false;
    }

    private static Map<Character, Integer> getFrequency(String string) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }
        return frequency;
    }
}
