// https://www.hackerrank.com/challenges/beautiful-binary-string/problem

package strings;

import java.util.Scanner;

public class BeautifulBinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String string = scanner.next();
        System.out.println(minimumSteps(string));
    }

    private static int minimumSteps(String string) {
        int deletions = 0;
        for (int index = 0 ; index < string.length() - 2 ; index++) {
            if (string.charAt(index) == '0' && string.charAt(index + 1) == '1' && string.charAt(index + 2) == '0') {
                deletions++;
                index += 2;
            }
        }
        return deletions;
    }
}
