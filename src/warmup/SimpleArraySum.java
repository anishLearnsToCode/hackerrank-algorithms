package warmup;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = scanner.nextInt();
        }
        System.out.println(Arrays.stream(array).sum());
    }
}
