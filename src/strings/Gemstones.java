// https://www.hackerrank.com/challenges/gem-stones/problem

package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Gemstones {
    private static final Scanner scanner = new Scanner(System.in);;

    public static void main(String[] args) {
        int length = scanner.nextInt();
        String[] array = getArray(length);
        System.out.println(numberOfGemstones(array));
    }

    private static String[] getArray(int length) {
        String[] array = new String[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.next();
        }
        return array;
    }

    private static int numberOfGemstones(String[] array) {
        List<Set<Character>> minerals = getMinerals(array);
        Map<Character, Integer> frequencies = gerFrequencies(minerals);
        int gemstones = 0;
        for (int frequency : frequencies.values()) {
            if (frequency == array.length) {
                gemstones++;
            }
        }
        return gemstones;
    }

    private static List<Set<Character>> getMinerals(String[] array) {
        List<Set<Character>> minerals = new ArrayList<>(array.length);
        for (String string : array) {
            minerals.add(getMinerals(string));
        }
        return minerals;
    }

    private static Set<Character> getMinerals(String string) {
        Set<Character> minerals = new HashSet<>();
        for (int index = 0 ; index < string.length() ; index++) {
            minerals.add(string.charAt(index));
        }
        return minerals;
    }

    private static Map<Character, Integer> gerFrequencies(List<Set<Character>> list) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (Set<Character> set : list) {
            for (Character character : set) {
                frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
            }
        }
        return frequencies;
    }
}
