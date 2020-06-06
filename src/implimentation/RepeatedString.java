// https://www.hackerrank.com/challenges/repeated-string/problem

package implimentation;

import java.util.Scanner;

public class RepeatedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        long length = scanner.nextLong();
        System.out.println(numberOfA(string, length));
    }

    private static long numberOfA(String string, long length) {
        long repetitions = length / string.length();
        long aInString = numberOfA(string);
        long extraA = numberOfA(string.substring(0, (int) (length % string.length())));
        return aInString * repetitions + extraA;
    }

    private static int numberOfA(String string) {
        int count = 0;
        for (int index = 0 ; index < string.length() ; index++) {
            if (string.charAt(index) == 'a') {
                count++;
            }
        }
        return count;
    }
}
