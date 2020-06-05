import java.util.Scanner;

public class test {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        int element = scanner.nextInt();
        System.out.println(search(array, element));
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
        return index - 1 >= 0 && index - 1 < array.length && array[index] < element;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
