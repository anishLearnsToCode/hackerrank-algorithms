// https://www.hackerrank.com/challenges/migratory-birds/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MigratoryBirds {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(mostCommonBird(array));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int mostCommonBird(int[] array) {
        Map<Integer, Integer> frequency = getFrequency(array);
        int maxFrequency = frequency.values().stream().max(Integer::compareTo).get();
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                result = Math.min(result, entry.getKey());
            }
        }
        return result;
    }

    private static Map<Integer, Integer> getFrequency(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : array) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
        }
        return frequencies;
    }
}
