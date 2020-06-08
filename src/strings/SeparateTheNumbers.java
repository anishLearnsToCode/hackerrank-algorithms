// https://www.hackerrank.com/challenges/separate-the-numbers/problem

package strings;

import java.util.Scanner;

public class SeparateTheNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            String result = beautifulNumber(string);
            System.out.println(result.length() == 0 ? "NO" : "YES " + result);
        }
    }

    private static String beautifulNumber(String string) {
        for (int index = 0 ; index < string.length() / 2 ; index++) {
            long number = Long.parseLong(string.substring(0, index + 1));
            if (isBeautifulNumber(string.substring(index + 1), String.valueOf(number + 1))) {
                return number + "";
            }
        }
        return "";
    }

    private static boolean isBeautifulNumber(String string, String number) {
        if (string.length() == 0) {
            return true;
        }
        if (string.startsWith(number)) {
            return isBeautifulNumber(string.substring(number.length()), String.valueOf(Long.parseLong(number) + 1));
        }
        return false;
    }
}
