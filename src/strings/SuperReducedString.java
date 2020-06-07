// https://www.hackerrank.com/challenges/reduced-string/problem

package strings;

import java.util.Scanner;

public class SuperReducedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(reducedString(string));
    }

    private static String reducedString(String string) {
        StringBuilder result = new StringBuilder();
        char current = string.charAt(0);
        int frequency = 1;

        for (int index = 1 ; index < string.length() ; index++) {
            if (string.charAt(index) == current) {
                frequency++;
            } else {
                if (frequency % 2 == 1 && (result.length() == 0 || result.charAt(result.length() - 1) != current)) {
                    result.append(current);
                } else if (frequency % 2 == 1 && result.length() > 0 && result.charAt(result.length() - 1) == current) {
                    result.deleteCharAt(result.length() - 1);
                }
                current = string.charAt(index);
                frequency = 1;
            }
        }

        if (frequency % 2 == 1 && result.length() > 0 && result.charAt(result.length() - 1) == current) {
            result.deleteCharAt(result.length() - 1);
        } else if (frequency % 2 == 1) {
            result.append(current);
        }

        return result.toString().equals("") ? "Empty String" : result.toString();
    }
}
