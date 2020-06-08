// https://www.hackerrank.com/challenges/two-strings/problem

package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String first = scanner.next();
            String second = scanner.next();
            System.out.println(commonLetter(first, second) ? "YES" : "NO");
        }
    }

    private static boolean commonLetter(String first, String second) {
        Set<Character> uniqueLetters1 = uniqueLetters(first);
        Set<Character> uniqueLetters2 = uniqueLetters(second);
        for (char character : uniqueLetters1) {
            if (uniqueLetters2.contains(character)) {
                return true;
            }
        }
        return false;
    }

    private static Set<Character> uniqueLetters(String string) {
        Set<Character> set = new HashSet<>();
        for (int index = 0 ; index < string.length() ; index++) {
            set.add(string.charAt(index));
        }
        return set;
    }
}
