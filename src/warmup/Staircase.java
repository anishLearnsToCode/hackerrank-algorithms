// https://www.hackerrank.com/challenges/staircase/problem

package warmup;

import java.util.Scanner;

public class Staircase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        printPattern(length);
    }

    private static void printPattern(int length) {
        for (int row = 0 ; row < length ; row++) {
            for (int i = 0 ; i < length - row - 1 ; i++) System.out.print(" ");
            for (int i = 0 ; i < row + 1 ; i++) System.out.print("#");
            System.out.println();
        }
    }
}
