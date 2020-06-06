//  https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrganizingContainersOfBalls {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int length = scanner.nextInt();
            long[][] containers = getMatrix(length);
            System.out.println(isPossibleToOrganize(containers) ? "Possible" : "Impossible");
        }
    }

    private static boolean isPossibleToOrganize(long[][] containers) {
        long[] containersCapacity = sumRows(containers);
        long[] ballsDistribution = sumColumns(containers);
        Map<Long, Integer> capacityFrequency = getFrequency(containersCapacity);
        Map<Long, Integer> ballsFrequency = getFrequency(ballsDistribution);
        return capacityFrequency.equals(ballsFrequency);
    }

    private static long[] sumRows(long[][] matrix) {
        long[] result = new long[matrix.length];
        for (int row = 0 ; row < matrix.length ; row++) {
            for (long number : matrix[row]) {
                result[row] += number;
            }
        }
        return result;
    }

    private static long[] sumColumns(long[][] matrix) {
        long[] result = new long[matrix.length];
        for (int column = 0 ; column < matrix.length ; column++) {
            for (int row = 0 ; row < matrix.length ; row++) {
                result[column] += matrix[row][column];
            }
        }
        return result;
    }

    private static Map<Long, Integer> getFrequency(long[] array) {
        Map<Long, Integer> frequency = new HashMap<>();
        for (long number : array) {
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }
        return frequency;
    }

    private static long[][] getMatrix(int length) {
        long[][] matrix = new long[length][length];
        for (int i = 0 ; i < length ; i++) {
            for (int j = 0 ; j < length ; j++) {
                matrix[i][j] = scanner.nextLong();
            }
        }
        return matrix;
    }
}
