// https://www.hackerrank.com/challenges/angry-professor/problem

package implimentation;

import java.util.Scanner;

public class AngryProfessor {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int students = scanner.nextInt();
            int threshold = scanner.nextInt();
            int[] arrivalTimes = getArray(students);
            System.out.println(isClassCancelled(arrivalTimes, threshold) ? "YES" : "NO");
        }
    }

    private static boolean isClassCancelled(int[] times, int threshold) {
        int lateStudents = lateStudents(times);
        return times.length - lateStudents < threshold;
    }

    private static int lateStudents(int[] array) {
        int count = 0;
        for (int number : array) {
            if (number > 0) {
                count++;
            }
        }
        return count;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
