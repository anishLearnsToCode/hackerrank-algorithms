// https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

package implimentation;

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(beautifulDays(start, end, k));
    }

    private static int beautifulDays(int start, int end, int k) {
        int beautifulDays = 0;
        for (int number = start ; number <= end ; number++) {
            if (Math.abs(number - reverse(number)) % k == 0) {
                beautifulDays++;
            }
        }
        return beautifulDays;
    }

    private static int reverse(int number) {
        StringBuilder stringBuilder = new StringBuilder(number + "").reverse();
        return Integer.parseInt(stringBuilder.toString());
    }
}
