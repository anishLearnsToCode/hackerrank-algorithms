// https://www.hackerrank.com/challenges/non-divisible-subset/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonDivisibleSubset {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(nonDivisibleSubsets(array, k));
    }

    private static int nonDivisibleSubsets(int[] array, int k) {
        Map<Integer, Integer> moduliFrequencies = getModuliFrequencies(array, k);
        int count = 0;
        for (int number = 1 ; number <= (k - 1) / 2 ; number++) {
            count += Math.max(
                    moduliFrequencies.getOrDefault(number, 0),
                    moduliFrequencies.getOrDefault(k - number, 0)
            );
        }
        return singleton(moduliFrequencies, 0)
                + (k % 2 == 0 ? singleton(moduliFrequencies, k / 2) : 0)
                + count;
    }

    private static int singleton(Map<Integer, Integer> frequencies, int key) {
        return frequencies.getOrDefault(key, 0) > 0 ? 1 : 0;
    }

    private static Map<Integer, Integer> getModuliFrequencies(int[] array, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : array) {
            int value = number % k;
            frequencies.put(value, frequencies.getOrDefault(value, 0) + 1);
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
