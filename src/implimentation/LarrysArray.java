// https://www.hackerrank.com/challenges/larrys-array/problem

package implimentation;

import java.util.Scanner;

public class LarrysArray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int length = scanner.nextInt();
            int[] array = getArray(length);
            printPossibleToSort(array);
        }
    }

    private static void printPossibleToSort(int[] array) {
        int factor = 1;
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i + 1 ; j < array.length ; j++) {
                factor ^= array[i] > array[j] ? 1 : 0;
            }
        }
        System.out.println(factor == 1 ? "YES" : "NO");
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
