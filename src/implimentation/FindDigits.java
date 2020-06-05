// https://www.hackerrank.com/challenges/find-digits/problem

package implimentation;

import java.util.Scanner;

public class FindDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int number = scanner.nextInt();
            System.out.println(digitDivisorsOf(number));
        }
    }

    private static int digitDivisorsOf(int number) {
        int count = 0;
        String representation = number + "";
        for (int index = 0 ; index < representation.length() ; index++) {
            int digit = Integer.parseInt(String.valueOf(representation.charAt(index)));
            if (digit == 0) {
                continue;
            }
            count += number % digit == 0 ? 1 : 0 ;
        }
        return count;
    }
}
