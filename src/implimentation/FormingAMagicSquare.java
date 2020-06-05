// https://www.hackerrank.com/challenges/magic-square-forming/problem

package implimentation;

import java.util.Scanner;

public class FormingAMagicSquare {
    private static final Scanner scanner = new Scanner(System.in);

    private static final int[][][] allPossibilities = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
    };

    public static void main(String[] args) {
        int[][] arr = getMatrix(3, 3);
        System.out.println(formingMagicSquare(arr));
    }

    static int formingMagicSquare(int[][] square) {
        int difference = Integer.MAX_VALUE;
        for (int[][] possibility : allPossibilities) {
            difference = Math.min(difference, difference(square, possibility));
        }
        return difference;
    }

    private static int difference(int[][] square, int[][] otherSquare) {
        int difference = 0;
        for (int row=0 ; row < square.length ; row++) {
            for (int column=0 ; column < square[row].length ; column++) {
                difference += Math.abs(otherSquare[row][column] - square[row][column]);
            }
        }
        return difference;
    }

    public static int[][] getMatrix(int rows, int columns){
        int[][] matrix = new int[rows][columns];
        for(int row = 0 ; row < rows ; row++){
            for(int column = 0 ; column < matrix[row].length ; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }
}