package warmup;

import java.util.Scanner;

public class PlusMinus {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        printFractions(array);
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static void printFractions(int[] array) {
        double positives = getPositives(array);
        double negatives = getNegatives(array);
        double zeros = array.length - positives - negatives ;
        System.out.println(positives / array.length);
        System.out.println(negatives / array.length);
        System.out.println(zeros / array.length);
    }

    private static double getPositives(int[] array) {
        int count = 0;
        for (int number : array) {
            if (number > 0) count++;
        }
        return count;
    }

    private static double getNegatives(int[] array) {
        int count = 0;
        for (int number : array) {
            if (number < 0) count++;
        }
        return count;
    }
}
