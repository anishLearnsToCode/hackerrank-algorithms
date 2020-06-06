// https://www.hackerrank.com/challenges/kaprekar-numbers/problem

package implimentation;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        printAllKaprekarNumbers(start, end);
    }

    private static void printAllKaprekarNumbers(int start, int end) {
        int count = 0;
        for (long number = start ; number <= end ; number++) {
            if (isKaprekarNumber(number)) {
                System.out.print(number + " ");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("INVALID RANGE");
        }
    }

    private static boolean isKaprekarNumber(long number) {
        String square = "0" + (number * number);
        int left = Integer.parseInt(square.substring(0, (square.length() + 1) / 2));
        int right = Integer.parseInt(square.substring((square.length() + 1) / 2));
        return number == (left + right);
    }
}
