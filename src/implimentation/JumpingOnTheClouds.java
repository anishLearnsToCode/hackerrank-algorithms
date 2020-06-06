// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

package implimentation;

import java.util.Scanner;

public class JumpingOnTheClouds {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(minimumDistance(array));
    }

    private static int minimumDistance(int[] array) {
        int[] result = new int[array.length];
        result[result.length - 2] = array[array.length - 2] == 1 ? Integer.MAX_VALUE : 1 ;
        for (int index = array.length - 3 ; index >= 0 ; index--) {
            result[index] = array[index] == 1
                    ? Integer.MAX_VALUE
                    : 1 + Math.min(result[index + 1], result[index + 2]);
        }
        return result[0];
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
