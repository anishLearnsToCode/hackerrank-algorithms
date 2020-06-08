// https://www.hackerrank.com/challenges/funny-string/problem

package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunnyString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String string = scanner.next();
            System.out.println(isFunny(string) ? "Funny" : "Not Funny");
        }
    }

    private static boolean isFunny(String string) {
        String reversed = reverse(string);
        List<Integer> stringAsciiDifference = difference(string);
        List<Integer> reverseAsciiDifference = difference(reversed);
        return stringAsciiDifference.equals(reverseAsciiDifference);
    }

    private static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    private static List<Integer> difference(String string) {
        List<Integer> result = new ArrayList<>(string.length() - 1);
        for (int index = 0 ; index < string.length() - 1 ; index++) {
            result.add(Math.abs(string.charAt(index) - string.charAt(index + 1)));
        }
        return result;
    }
}
