// https://www.hackerrank.com/challenges/mars-exploration/problem

package strings;

import java.util.Scanner;

public class MarsExploration {
    private static final String SOS_MESSAGE = "SOS";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(alteredCharacters(string));
    }

    private static int alteredCharacters(String string) {
        int anomalies = 0;
        for (int block = 0 ; block < string.length() / 3 ; block++) {
            for (int index = 0 ; index < 3 ; index++) {
                anomalies += string.charAt(block * 3 + index) == SOS_MESSAGE.charAt(index) ? 0 : 1;
            }
        }
        return anomalies;
    }
}
