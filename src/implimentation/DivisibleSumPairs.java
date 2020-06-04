// https://www.hackerrank.com/challenges/divisible-sum-pairs/problem

package implimentation;

import java.util.Scanner;

public class DivisibleSumPairs {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(possiblePairs(array, k));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int possiblePairs(int[] array, int k) {
        int[] frequencyCounter = new int[k];
        frequencyCounter[array[array.length - 1] % k]++;
        int result = 0;
        for (int index = array.length - 2 ; index >= 0 ; index--) {
            result += frequencyCounter[(k - array[index] % k) % k];
            frequencyCounter[array[index] % k]++;
        }
        return result;
    }
}
