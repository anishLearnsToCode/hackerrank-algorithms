// https://www.hackerrank.com/challenges/permutation-equation/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SequenceEquation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        int[] result = getFunctionalInverse(array);
        print(result);
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static void print(int[] array) {
        for (int number : array) {
            System.out.println(number);
        }
    }

    private static int[] getFunctionalInverse(int[] array) {
        Map<Integer, Integer> indices = getIndices(array);
        int[] result = new int[array.length];
        for (int number = 1 ; number <= result.length ; number++) {
            result[number - 1] = indices.get(indices.get(number));
        }
        return result;
    }

    private static Map<Integer, Integer> getIndices(int[] array) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            indices.put(array[index], index + 1);
        }
        return indices;
    }
}
