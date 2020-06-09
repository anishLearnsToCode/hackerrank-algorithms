// https://www.hackerrank.com/challenges/common-child/problem
// Longest Common Subsequence Problem

package strings;

import java.util.Scanner;

public class CommonChild {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        System.out.println(longestCommonSubsequenceLength(first, second));
    }

    private static int longestCommonSubsequenceLength(String first, String second) {
        int rows = first.length() + 1, columns = second.length() + 1;
        int[][] matrix = new int[rows][columns];
        for (int row = 1 ; row < rows ; row++) {
            for (int column = 1 ; column < columns ; column++) {
                matrix[row][column] = max(
                        matrix[row][column - 1],
                        matrix[row - 1][column],
                        first.charAt(row - 1) == second.charAt(column - 1) ? matrix[row - 1][column - 1] + 1 : 0
                );
            }
        }

        return matrix[rows - 1][columns - 1];
    }

    private static int max(int... numbers) {
        int maximum = 0;
        for (int number : numbers) {
            maximum = Math.max(maximum, number);
        }
        return maximum;
    }
}
