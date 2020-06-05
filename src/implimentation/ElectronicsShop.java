// https://www.hackerrank.com/challenges/electronics-shop/problem

package implimentation;

import java.util.Arrays;
import java.util.Scanner;

public class ElectronicsShop {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int money = scanner.nextInt();
        int keyboardCount = scanner.nextInt();
        int driveCount = scanner.nextInt();
        int[] keyboards = getArray(keyboardCount);
        int[] drives = getArray(driveCount);
        System.out.println(maximumMoneySpent(money, keyboards, drives));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int maximumMoneySpent(int money, int[] keyboards, int[] drives) {
        Arrays.sort(drives);
        int maximumMoneySpent = Integer.MIN_VALUE;
        for (int keyboardCost : keyboards) {
            int left = money - keyboardCost;
            if (left < 0) {
                continue;
            }
            int driveIndex = search(drives, left);
            if (driveIndex == -1) {
                continue;
            }

            maximumMoneySpent = Math.max(maximumMoneySpent, keyboardCost + drives[driveIndex]);
        }

        return maximumMoneySpent == Integer.MIN_VALUE ? -1 : maximumMoneySpent;
    }

    // Binary Search that will return the exact or nearest smallest value if absent
    // and -1 of item not found and no smaller value available
    private static int search(int[] array, int element) {
        int mid = array.length / 2;
        for (int start = 0, end = array.length ; start <= end && mid < array.length && mid >= 0 ; mid = (start + end) / 2) {
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] < element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (check(array, mid + 1, element)) {
            return mid + 1;
        } else if (check(array, mid, element)) {
            return mid;
        } else if (check(array, mid - 1, element)) {
            return mid - 1;
        }
        return -1;
    }

    private static boolean check(int[] array, int index, int element) {
        return index >= 0 && index < array.length && array[index] < element;
    }
}
