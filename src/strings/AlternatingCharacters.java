// https://www.hackerrank.com/challenges/alternating-characters/problem

package strings;

import java.util.Scanner;

public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(minimumDeletions(string));
        }
    }

    private static int minimumDeletions(String string) {
        char current = string.charAt(0);
        int deletions = 0;
        for (int index = 1 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (current == character) {
                deletions++;
            } else {
                current = character;
            }
        }
        return deletions;
    }
}
