// https://www.hackerrank.com/challenges/bon-appetit/problem

package implimentation;

import java.util.Scanner;

public class BonAppetit {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int ignored = scanner.nextInt();
        int[] array = getArray(length);
        int splitAmount = scanner.nextInt();
        int moneyOwedByBob = moneyOwed(array, splitAmount, ignored);
        System.out.println(moneyOwedByBob == 0 ? "Bon Appetit" : moneyOwedByBob);
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int moneyOwed(int[] array, int split, int ignored) {
        int sharedAmount = sharedAmount(array, ignored);
        return split - sharedAmount / 2;
    }

    private static int sharedAmount(int[] array, int ignored) {
        int sum = 0;
        for (int index = 0 ; index < array.length ; index++) {
            if (index == ignored) {
                continue;
            }
            sum += array[index];
        }
        return sum;
    }
}
