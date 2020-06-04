// https://www.hackerrank.com/challenges/the-birthday-bar/problem

package implimentation;

import java.util.Scanner;

public class BirthdayChocolate {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] chocolate = getArray(length);
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        System.out.println(possibleWays(chocolate, month, day));
    }

    private static int possibleWays(int[] array, int length, int sum) {
        int window = getWindow(array, length);
        int count = window == sum ? 1 : 0 ;
        for (int index = length ; index < array.length ; index++) {
            window += array[index] - array[index - length];
            count += window == sum ? 1 : 0 ;
        }
        return count;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int getWindow(int[] array, int length) {
        int sum = 0;
        for (int index = 0 ; index < length ; index++) {
            sum += array[index];
        }
        return sum;
    }
}
