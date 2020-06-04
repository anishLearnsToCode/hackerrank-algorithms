// https://www.hackerrank.com/challenges/apple-and-orange/problem

package implimentation;

import java.util.Scanner;

public class AppleAndOrange {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int appleTree = scanner.nextInt();
        int orangeTree = scanner.nextInt();
        int apples = scanner.nextInt();
        int oranges = scanner.nextInt();
        int[] appleDistances = getArray(apples);
        int[] orangeDistances = getArray(oranges);
        System.out.println(inRange(appleDistances, start, end, appleTree));
        System.out.println(inRange(orangeDistances, start, end, orangeTree));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int inRange(int[] distances, int start, int end, int tree) {
        int count = 0;
        for (int distance : distances) {
            int position = tree + distance;
            count += position <= end && position >= start ? 1 : 0 ;
        }
        return count;
    }
}
