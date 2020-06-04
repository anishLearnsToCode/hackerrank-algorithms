// https://www.hackerrank.com/challenges/birthday-cake-candles/problem

package warmup;

import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandles {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(blownCandles(array));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int blownCandles(int[] array) {
        int maximum = Arrays.stream(array).max().getAsInt();
        return frequency(array, maximum);
    }

    private static int frequency(int[] array, int element) {
        int count = 0;
        for (int number : array) {
            if (number == element) {
                count++;
            }
        }
        return count;
    }
}
