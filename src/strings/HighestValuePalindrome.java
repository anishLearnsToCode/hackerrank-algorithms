// https://www.hackerrank.com/challenges/richie-rich/problem

package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HighestValuePalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int operations = scanner.nextInt();
        String string = scanner.next();
        System.out.println(highestPalindromicNumber(string, operations));
    }

    private static String highestPalindromicNumber(String string, int operations) {
        char[] array = string.toCharArray();
        Set<Integer> malformed = malformed(array);
        if (operations < malformed.size()) {
            return "-1";
        }

        for (int index = 0 ; index < array.length / 2 && operations > 0 ; index++) {
            if (!malformed.contains(index) && array[index] != '9' && operations - 2 >= malformed.size()) {
                array[index] = array[array.length - 1 - index] = '9';
                operations -= 2;
            } else if (malformed.contains(index) && array[index] != '9' && array[array.length - 1 - index] != '9' && operations - 2 >= malformed.size() - 1) {
                array[index] = array[array.length - 1 - index] = '9';
                malformed.remove(index);
                operations -= 2;
            } else if (malformed.contains(index)) {
                char maxElement = (char) Math.max(array[index], array[array.length - 1 - index]);
                array[index] = array[array.length - 1 - index] = maxElement;
                malformed.remove(index);
                operations--;
            }
        }
        if (operations > 0 && array.length % 2 == 1) {
            array[array.length / 2] = '9';
        }

        return new String(array);
    }

    private static Set<Integer> malformed(char[] array) {
        Set<Integer> set = new HashSet<>();
        for (int index = 0 ; index < array.length / 2 ; index++) {
            if (array[index] != array[array.length - 1 - index]) {
                set.add(index);
            }
        }
        return set;
    }

}
