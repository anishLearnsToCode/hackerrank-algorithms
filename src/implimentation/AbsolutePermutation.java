// https://www.hackerrank.com/challenges/absolute-permutation/problem

package implimentation;

import java.util.Scanner;

public class AbsolutePermutation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int length = scanner.nextInt();
            int difference = scanner.nextInt();
            printLexicographicallySmallestPermutation(length, difference);
        }
    }

    private static void printLexicographicallySmallestPermutation(int length, int difference) {
        int[] permutation = lexicographicallySmallestPermutation(length, difference);
        if (permutation.length == 0) {
            System.out.println("-1");
            return;
        }
        print(permutation);
    }

    private static int[] lexicographicallySmallestPermutation(int length, int difference) {
        if (difference == 0) {
            return generateArray(length);
        } else if (length % (2 * difference) != 0) {
            return new int[0];
        }

        int[] permutation = new int[length];
        for (int block = 0 ; block < length / (2 * difference) ; block++) {
            for (int index = 0 ; index < difference ; index++) {
                permutation[2 * difference * block + index] = 2 * block * difference + index + difference + 1;
                permutation[2 * difference * block + index + difference] = 2 * block * difference + index + 1;
            }
        }
        return permutation;
    }

    private static int[] generateArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = index + 1;
        }
        return array;
    }

    private static void print(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
