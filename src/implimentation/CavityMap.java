// https://www.hackerrank.com/challenges/cavity-map/problem

package implimentation;

import java.util.Scanner;

public class CavityMap {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        String[] map = getMatrix(length);
        StringBuilder[] cavities = markCavities(map);
        print(cavities);
    }

    private static StringBuilder[] markCavities(String[] array) {
        StringBuilder[] result = new StringBuilder[array.length];
        result[0] = new StringBuilder(array[0]);
        result[array.length - 1] = new StringBuilder(array[array.length - 1]);

        for (int row = 1 ; row < array.length - 1 ; row++) {
            result[row] = new StringBuilder().append(array[row].charAt(0));
            for (int column = 1 ; column < array.length - 1 ; column++) {
                result[row].append(isCavity(array, row, column) ? "X" : array[row].charAt(column));
            }
            result[row].append(array[row].charAt(array.length - 1));
        }

        return result;
    }

    private static boolean isCavity(String[] array, int row, int column) {
        char cavity = array[row].charAt(column);
        return array[row -1].charAt(column) < cavity
                && array[row].charAt(column + 1) < cavity
                && array[row + 1].charAt(column) < cavity
                && array[row].charAt(column - 1) < cavity;
    }

    private static void print(StringBuilder[] array) {
        for(StringBuilder element : array) {
            System.out.println(element);
        }
    }

    private static String[] getMatrix(int length) {
        String[] array = new String[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = scanner.next();
        }
        return array;
    }
}
