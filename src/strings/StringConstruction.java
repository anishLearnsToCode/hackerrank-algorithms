// https://www.hackerrank.com/challenges/string-construction/problem

package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(uniqueLetters(string));
        }
    }

    private static int uniqueLetters(String string) {
        Set<Character> letters = lettersIn(string);
        return letters.size();
    }

    private static Set<Character> lettersIn(String string) {
        Set<Character> letters = new HashSet<>();
        for (int index = 0 ; index < string.length() ; index++) {
            letters.add(string.charAt(index));
        }
        return letters;
    }
}
