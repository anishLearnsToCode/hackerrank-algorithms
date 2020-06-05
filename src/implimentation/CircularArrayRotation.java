// https://www.hackerrank.com/challenges/circular-array-rotation/problem

package implimentation;

import java.util.Scanner;

public class CircularArrayRotation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int rotations = scanner.nextInt() % length;
        int queries = scanner.nextInt();
        int[] array = getArray(length);
        while (queries-- > 0) {
            int index = scanner.nextInt();
            int rotatedIndex = (index - rotations + length) % length;
            System.out.println(array[rotatedIndex]);
        }
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
