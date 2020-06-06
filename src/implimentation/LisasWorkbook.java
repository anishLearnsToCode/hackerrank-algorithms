// https://www.hackerrank.com/challenges/lisa-workbook/problem

package implimentation;

import java.util.Scanner;

public class LisasWorkbook {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(specialQuestions(array, k));
    }

    private static int specialQuestions(int[] array, int k) {
        int special = 0;
        for (int chapter = 0, start = 1, page = 1 ; chapter < array.length ; page++) {
            if (array[chapter] <= 0) {
                start = 1;
                chapter++;
                page--;
                continue;
            }

            int end = start + Math.min(array[chapter], k) - 1;
            if (start <= page && page <= end) {
                special++;
            }
            array[chapter] -= k;
            start += k;
        }

        return special;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
