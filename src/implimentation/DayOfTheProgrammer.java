// https://www.hackerrank.com/challenges/day-of-the-programmer/problem

package implimentation;

import java.util.Scanner;

public class DayOfTheProgrammer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println(dayOfProgrammer(year));
    }

    private static String dayOfProgrammer(int year) {
        if (year == 1918) {
            return "26.09.1918";
        }
        return (isLeapYear(year) ? "12.09." : "13.09.") + year;
    }

    private static boolean isLeapYear(int year) {
        return (year <= 1917 && year % 4 == 0)
                || (year % 400 == 0 || (year  % 4 == 0 && year % 100 != 0));
    }
}
