// https://www.hackerrank.com/challenges/equality-in-a-array/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualizeTheArray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(minimumDeletions(array));
    }

    private static int minimumDeletions(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        int maxFrequency = frequencies.values().stream().max(Integer::compareTo).get();
        return array.length - maxFrequency;
    }

    private static Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : array) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
        }
        return frequencies;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
