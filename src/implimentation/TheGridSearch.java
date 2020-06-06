// https://www.hackerrank.com/challenges/the-grid-search/problem

package implimentation;

import java.util.Scanner;

public class TheGridSearch {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int gridRows = scanner.nextInt();
            int gridColumns = scanner.nextInt();
            String[] grid = getMatrix(gridRows);
            int patternRows = scanner.nextInt();
            int patternColumns = scanner.nextInt();
            String[] pattern = getMatrix(patternRows);
            System.out.println(patternPresentIn(grid, pattern) ? "YES" : "NO");
        }
    }

    private static boolean patternPresentIn(String[] grid, String[] pattern) {
        for (int row = 0 ; row < grid.length - pattern.length + 1 ; row++) {
            for (int column = 0 ; column < grid[0].length() - pattern[0].length() + 1 ; column++) {
                if (grid[row].charAt(column) == pattern[0].charAt(0) && matches(grid, pattern, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean matches(String[] grid, String[] pattern, int row, int column) {
        for (int i = 0 ; i < pattern.length ; i++) {
            for (int j = 0 ; j < pattern[i].length() ; j++) {
                if (grid[row + i].charAt(column + j) != pattern[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String[] getMatrix(int rows) {
        String[] matrix = new String[rows];
        for (int row = 0 ; row < rows ; row++) {
            matrix[row] = scanner.next();
        }
        return matrix;
    }
}
