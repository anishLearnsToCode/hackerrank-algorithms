package warmup;

import java.util.Arrays;
import java.util.Scanner;

public class AVeryBigSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        long[] array = new long[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextLong();
        }
        System.out.println(Arrays.stream(array).sum());
    }
}
