// https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

package implimentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixLayerRotation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int rotations = scanner.nextInt();
        int[][] matrix = getMatrix(rows, columns);
        int[][] result = rotateMatrix(matrix, rotations);
        print(result);
    }

    private static int[][] rotateMatrix(int[][] matrix, int rotations) {
        int rows = matrix.length, columns = matrix[0].length;
        int frames = (Math.min(rows, columns) + 1) / 2;
        int[][] result = new int[rows][columns];

        for (int frame = 0 ; frame < frames ; frame++) {
            List<Integer> elements = getFrameElements(matrix, frame);
            int frameElements = elements.size();
            int frameRotations = rotations % frameElements ;
            addListInResult(result, elements, frame, frameRotations);
        }

        return result;
    }

    private static void addListInResult(int[][] result, List<Integer> elements, int frame, int rotations) {
        int rows = result.length, columns = result[0].length;
        int index = rotations;

        for (int column = frame; column < columns - frame ; column++, index = (index + 1) % elements.size()) {
            result[frame][column] = elements.get(index);
        }

        for (int row = frame + 1, column = columns - 1 - frame ; row < rows - frame ; row++, index = (index + 1) % elements.size()) {
            result[row][column] = elements.get(index);
        }

        for (int row = rows - 1 - frame, column = columns - 2 - frame ; column >= frame ; column--, index = (index + 1) % elements.size()) {
            result[row][column] = elements.get(index);
        }

        for (int row = rows - 2 - frame; row > frame ; row--, index = (index + 1) % elements.size()) {
            result[row][frame] = elements.get(index);
        }
    }

    private static List<Integer> getFrameElements(int[][] matrix, int frame) {
        List<Integer> elements = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;

        for (int row = frame, column = frame ; column < columns - frame ; column++) {
            elements.add(matrix[row][column]);
        }

        for (int row = frame + 1, column = columns - 1 - frame ; row < rows - frame ; row++) {
            elements.add(matrix[row][column]);
        }

        if (frame == rows - 1 - frame) {
            return elements;
        }

        for (int row = rows - 1 - frame, column = columns - 2 - frame ; column >= frame ; column--) {
            elements.add(matrix[row][column]);
        }

        for (int row = rows - 2 - frame, column = frame ; row > frame ; row--) {
            elements.add(matrix[row][column]);
        }

        return elements;
    }

    private static int[][] getMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < columns ; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
