// https://www.hackerrank.com/challenges/the-love-letter-mystery/problem

package strings;

import java.util.Scanner;

public class TheLoveLetterMystery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(minimumChanges(string));
        }
    }

    private static int minimumChanges(String string) {
        int changes = 0;
        for (int index = 0 ; index < string.length() / 2 ; index++) {
            changes += Math.abs(string.charAt(index) - string.charAt(string.length() - 1 - index));
        }
        return changes;
    }
}
