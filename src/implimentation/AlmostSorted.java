// https://www.hackerrank.com/challenges/almost-sorted/problem

package implimentation;

import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        operationForSort(array);
    }

    private static void operationForSort(int[] array) {
        if (isSorted(array)) {
            System.out.println("yes");
            return;
        }

        int[] sortedArray = sortedArray(array);
        int leftMisplacedIndex = leftMisplacedIndex(array, sortedArray);
        int rightMisplacesIndex = rightMisplacedIndex(array, sortedArray);

        swap(array, leftMisplacedIndex, rightMisplacesIndex);
        if (isSorted(array)) {
            System.out.println("yes");
            System.out.println(String.format("swap %d %d", leftMisplacedIndex + 1, rightMisplacesIndex + 1));
            return;
        }

        swap(array, leftMisplacedIndex, rightMisplacesIndex);
        int[] reversed = reverse(array, leftMisplacedIndex, rightMisplacesIndex + 1);
        if (isSorted(reversed)) {
            System.out.println("yes");
            System.out.println(String.format("reverse %d %d", leftMisplacedIndex + 1, rightMisplacesIndex + 1));
            return;
        }

        System.out.println("no");
    }

    private static int[] sortedArray(int[] array) {
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    private static int[] reverse(int[] array, int startIndex, int endIndex) {
        int[] reversed = new int[endIndex - startIndex];
        for (int index = startIndex ; index < endIndex ; index++) {
            reversed[index - startIndex] = array[endIndex - index + startIndex - 1];
        }
        return reversed;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static int leftMisplacedIndex(int[] array, int[] sortedArray) {
        for (int index = 0 ; index < array.length ; index++) {
            if (array[index] != sortedArray[index]) {
                return index;
            }
        }
        return -1;
    }

    private static int rightMisplacedIndex(int[] array, int[] sortedArray) {
        for (int index = array.length - 1 ; index >= 0 ; index--) {
            if (array[index] != sortedArray[index]) {
                return index;
            }
        }
        return -1;
    }

    private static boolean isSorted(int[] array) {
        for (int index = 0 ; index < array.length - 1 ; index++) {
            if (array[index] > array[index + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
