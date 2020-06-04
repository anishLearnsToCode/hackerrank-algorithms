// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

package implimentation;

import java.util.Scanner;

public class BreakingTheRecords {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] scores = getArray(length);
        printMinMax(scores);
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static void printMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        int maximumRecordBroke = 0;
        int minimumRecordBroke = 0;
        for (int number : array) {
            if (number > max) {
                max = number;
                maximumRecordBroke++;
            } else if (number < min) {
                min = number;
                minimumRecordBroke++;
            }
        }
        System.out.println(maximumRecordBroke + " " + minimumRecordBroke);
    }
}
