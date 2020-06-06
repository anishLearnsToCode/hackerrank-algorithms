// https://www.hackerrank.com/challenges/beautiful-triplets/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BeautifulTriplets {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int difference = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(beautifulTriplets(array, difference));
    }

    private static long beautifulTriplets(int[] array, int difference) {
        Map<Integer, Integer> pairs = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(array[array.length - 1], 1);
        long beautifulTriplets = 0;
        for (int index = array.length - 2 ; index >= 0 ; index--) {
            int number = array[index];
            pairs.put(number, pairs.getOrDefault(number, 0)
                    + frequency.getOrDefault(number + difference, 0));
            beautifulTriplets += pairs.getOrDefault(number + difference, 0);
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }
        return beautifulTriplets;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
