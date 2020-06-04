package warmup;

import java.util.Scanner;

public class DiagonalDifference {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[][] matrix = getMatrix(length);
        System.out.println(absoluteDiagonalDifference(matrix));
    }

    private static int[][] getMatrix(int length) {
        int[][] matrix = new int[length][length];
        for (int row = 0 ; row < length ; row++) {
            for (int column = 0 ; column < length ; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int absoluteDiagonalDifference(int[][] matrix) {
        int leftDiagonal = getLeftDiagonal(matrix);
        int rightDiagonal = getRightDiagonal(matrix);
        return Math.abs(rightDiagonal - leftDiagonal);
    }

    private static int getLeftDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0 ; row < matrix.length ; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }

    private static int getRightDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0 ; row < matrix.length ; row++) {
            sum += matrix[row][matrix.length - row - 1];
        }
        return sum;
    }
}
