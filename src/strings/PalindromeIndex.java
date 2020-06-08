// https://www.hackerrank.com/challenges/palindrome-index/problem

package strings;

import java.util.Scanner;

public class PalindromeIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(palindromicIndex(string));
        }
    }

    private static int palindromicIndex(String string) {
        for (int index = 0 ; index < (string.length() + 1) / 2 ; index++) {
            if (string.charAt(index) != string.charAt(string.length() - 1 - index)) {
                if (isPalindrome(string.substring(0, index) + string.substring(index + 1))) {
                    return index;
                }
                return string.length() - 1 - index;
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String string) {
        for (int index = 0 ; index < string.length() / 2 ; index++) {
            if (string.charAt(index) != string.charAt(string.length() - 1 - index)) {
                return false;
            }
        }
        return true;
    }
}
