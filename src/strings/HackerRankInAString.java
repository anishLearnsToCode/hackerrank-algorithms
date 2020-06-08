// https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem

package strings;

import java.util.*;

public class HackerRankInAString {
    private static final String HACKERRANK = "hackerrank";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(containsHackerRank(string) ? "YES" : "NO");
        }
    }

    private static boolean containsHackerRank(String string) {
        for (int index = 0, pointer = 0 ; index < string.length() ; index++) {
            if (string.charAt(index) == HACKERRANK.charAt(pointer)) {
                pointer++;
            }
            if (pointer == HACKERRANK.length()) {
                return true;
            }
        }
        return false;
    }
}
