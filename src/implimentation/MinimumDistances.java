// https://www.hackerrank.com/challenges/minimum-distances/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumDistances {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(minimumDistance(array));
    }

    private static int minimumDistance(int[] array) {
        int minimumDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> indices = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            if (!indices.containsKey(array[index])) {
                indices.put(array[index], index);
                continue;
            }

            minimumDistance = Math.min(minimumDistance, index - indices.get(array[index]));
        }

        return minimumDistance == Integer.MAX_VALUE ? -1 : minimumDistance;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
