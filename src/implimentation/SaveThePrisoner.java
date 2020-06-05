// https://www.hackerrank.com/challenges/save-the-prisoner/problem

package implimentation;

import java.util.Scanner;

public class SaveThePrisoner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            long prisoners = scanner.nextLong();
            long sweets = scanner.nextLong();
            long startIndex = scanner.nextLong();
            System.out.println(unluckyPrisoner(prisoners, sweets, startIndex));
        }
    }

    private static long unluckyPrisoner(long prisoners, long sweets, long startIndex) {
        return ((startIndex - 1) + sweets % prisoners - 1 + prisoners) % prisoners + 1;
    }
}
