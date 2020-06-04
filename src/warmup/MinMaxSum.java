package warmup;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxSum {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long[] array = getArray();
        printMinMaxSum(array);
    }

    private static long[] getArray() {
        long[] array = new long[5];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static void printMinMaxSum(long[] array) {
        long minimum = Arrays.stream(array).min().getAsLong();
        long maximum = Arrays.stream(array).max().getAsLong();
        long sum = Arrays.stream(array).sum();
        long minSum = sum - maximum;
        long maxSum = sum - minimum;
        System.out.println(minSum + " " + maxSum);
    }
}
