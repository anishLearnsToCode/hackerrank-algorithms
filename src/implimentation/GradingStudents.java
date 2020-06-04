// https://www.hackerrank.com/challenges/grading/problem

package implimentation;

import java.util.Scanner;

public class GradingStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int grade = scanner.nextInt();
            System.out.println(modifiedGrade(grade));
        }
    }

    private static int modifiedGrade(int grade) {
        if (grade < 38) {
            return grade;
        }
        int next = (grade / 5) * 5 + 5 ;
        return next - grade < 3 ? next : grade;
    }
}
