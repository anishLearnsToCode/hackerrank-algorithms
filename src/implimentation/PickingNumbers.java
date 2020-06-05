// https://www.hackerrank.com/challenges/picking-numbers/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PickingNumbers {
    private static final Scanner scanner = new Scanner(System.in);;

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(longestSubSet(array));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int longestSubSet(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        int result = 0;
        for (int number = 0 ; number <= 100 ; number++) {
            result = Math.max(
                    result,
                    frequencies.getOrDefault(number, 0)
                            + frequencies.getOrDefault(number + 1, 0)
            );
        }
        return result;
    }

    private static Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : array) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
        }
        return frequencies;
    }
}
