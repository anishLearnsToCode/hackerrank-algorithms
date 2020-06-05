// https://www.hackerrank.com/challenges/the-hurdle-race/problem

package implimentation;

import java.util.Arrays;
import java.util.Scanner;

public class TheHurdleRace {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int maxHeight = scanner.nextInt();
        int[] heights = getArray(length);
        System.out.println(potionRequired(heights, maxHeight));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int potionRequired(int[] array, int maxHeight) {
        int largestHurdle = Arrays.stream(array).max().getAsInt();
        int required = largestHurdle - maxHeight;
        return Math.max(required, 0);
    }
}
