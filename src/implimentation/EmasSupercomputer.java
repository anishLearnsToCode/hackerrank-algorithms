// https://www.hackerrank.com/challenges/two-pluses/problem

package implimentation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class EmasSupercomputer {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        String[] grid = getGrid(rows);
        System.out.println(maxAreaPluses(grid));
    }

    private static int maxAreaPluses(String[] array) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[][] memory = new int[array.length + 2][array[0].length() + 2];

        for (int row = 0 ; row < array.length ; row++) {
            for (int column = 0 ; column < array[row].length() ; column++) {
                if (array[row].charAt(column) == 'G') {
                    int plusSize = plusSize(array, row, column);
                    if (greaterThan(plusSize, memory, row + 1, column + 1)) {
                        maxHeap.removeAll(getAdjacent(memory, row + 1, column + 1, plusSize));
                    } else {
                        plusSize = 1;
                    }

                    maxHeap.add(plusSize);
                    memory[row + 1][column + 1] = plusSize;
                }
            }
        }

        return maxHeap.poll() * maxHeap.poll();
    }

    private static boolean greaterThan(int size, int[][] memory, int row, int column) {
        return memory[row][column - 1] < size
                && memory[row - 1][column] < size
                && memory[row][column + 1] < size
                && memory[row + 1][column] < size;
    }

    private static List<Integer> getAdjacent(int[][] memory, int row, int column, int size) {
        List<Integer> list = new ArrayList<>();
        int armLength = (size - 1) / 4;
        for (int index = row - armLength ; index <= row + armLength ; index++) {
            addToListIfExists(list, memory[index][column]);
        }
        for (int index = column - armLength ; index <= column + armLength ; index++) {
            addToListIfExists(list, memory[row][index]);
        }

        return list;
    }

    private static void addToListIfExists(List<Integer> list, int element) {
        if (element > 0) {
            list.add(element);
        }
    }

    private static int plusSize(String[] array, int row, int column) {
        int degreeOfFreedom = min(
                column,
                array[0].length() - column - 1,
                row,
                array.length - row - 1
        );
        int minArmLength = min(
                maxUpperArmLength(array, row, column, degreeOfFreedom),
                maxLowerArmLength(array, row, column, degreeOfFreedom),
                maxLeftArmLength(array, row, column, degreeOfFreedom),
                maxRightArmLength(array, row, column, degreeOfFreedom)
        );
        return 1 + 4 * minArmLength;
    }

    private static int min(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            min = Math.min(min, number);
        }
        return min;
    }

    private static int maxRightArmLength(String[] array, int row, int column, int degree) {
        int armLength = 0;
        for (int index = column + 1 ; index <= column + degree ; index++) {
            if (array[row].charAt(index) == 'B') {
                break;
            }
            armLength++;
        }
        return armLength;
    }

    private static int maxLeftArmLength(String[] array, int row, int column, int degree) {
        int armLength = 0;
        for (int index = column - 1 ; index >= column - degree ; index--) {
            if (array[row].charAt(index) == 'B') {
                break;
            }
            armLength++;
        }
        return armLength;
    }

    private static int maxUpperArmLength(String[] array, int row, int column, int degreeOfFreedom) {
        int armLength = 0;
        for (int index = row - 1 ; index >= row - degreeOfFreedom ; index--) {
            if (array[index].charAt(column) == 'B') {
                break;
            }
            armLength++;
        }
        return armLength;
    }

    private static int maxLowerArmLength(String[] array, int row, int column, int degreeOfFreedom) {
        int armLength = 0;
        for (int index = row + 1 ; index <= row + degreeOfFreedom ; index++) {
            if (array[index].charAt(column) == 'B') {
                break;
            }
            armLength++;
        }
        return armLength;
    }

    private static String[] getGrid(int length) {
        String[] array = new String[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.next();
        }
        return array;
    }
}
