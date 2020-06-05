// https://www.hackerrank.com/challenges/sherlock-and-squares/problem

package implimentation;

import java.util.Scanner;

public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            System.out.println(squaresIn(start, end));
        }
    }

    private static int squaresIn(int start, int end) {
        return (int) (Math.sqrt(end)) - (int)(Math.sqrt(start - 1));
    }
}
