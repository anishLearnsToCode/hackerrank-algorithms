package implimentation;

import java.util.Scanner;

public class ThreeDSurfaceArea {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        int[][] matrix = getMatrix(height + 2, width + 2);
        System.out.println(surfaceArea(matrix, height, width));
    }

    private static int surfaceArea(int[][] matrix, int height, int width) {
        int surfaceArea = height * width ;

        for (int row=1 ; row < height+1 ; row++) {
            for (int column = 1; column < width+1 ; column++) {

                if (column == 1) {
                    surfaceArea += Math.abs(matrix[row][column] - matrix[row][column-1]);
                }

                surfaceArea += Math.abs(matrix[row][column] - matrix[row][column + 1])
                        + Math.abs(matrix[row][column] - matrix[row - 1][column])
                        + 1;
            }

            if (row == height) {
                for (int heights : matrix[row]) {
                    surfaceArea += heights;
                }
            }
        }

        return surfaceArea;
    }

    private static int[][] getMatrix(int length, int width) {
        int[][] matrix = new int[length][width];
        for (int row=1 ; row < matrix.length-1; row++) {
            for (int column=1 ; column < matrix[row].length-1 ; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
