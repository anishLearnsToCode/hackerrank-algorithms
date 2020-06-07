// https://www.hackerrank.com/challenges/strong-password/problem

package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StrongPassword {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String password = scanner.next();
        System.out.println(minimumCharactersRequiredToMakeStrong(password));
    }

    private static int minimumCharactersRequiredToMakeStrong(String string) {
        Set<Character> characters = getElements(string);
        int count = 0;
        count += containsDigit(characters) ? 0 : 1;
        count += containsLowerCase(characters) ? 0 : 1;
        count += containsUpperCase(characters) ? 0 : 1;
        count += containsSpecialCharacter(characters) ? 0 : 1;
        return (string.length() + count) >= 6 ? count : 6 - string.length();
    }

    private static Set<Character> getElements(String string) {
        Set<Character> set = new HashSet<>();
        for (int index = 0 ; index < string.length() ; index++) {
            set.add(string.charAt(index));
        }
        return set;
    }

    private static boolean containsDigit(Set<Character> elements) {
        return containsLetter(elements, '0', '9');
    }

    private static boolean containsLowerCase(Set<Character> elements) {
        return containsLetter(elements, 'a', 'z');
    }

    private static boolean containsUpperCase(Set<Character> elements) {
        return containsLetter(elements, 'A', 'Z');
    }

    private static boolean containsSpecialCharacter(Set<Character> elements) {
        for (int index = 0 ; index < SPECIAL_CHARACTERS.length() ; index++) {
            if (elements.contains(SPECIAL_CHARACTERS.charAt(index))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLetter(Set<Character> elements, char start, char end) {
        for (char letter = start ; letter <= end ; letter++) {
            if (elements.contains(letter)) {
                return true;
            }
        }
        return false;
    }
}
