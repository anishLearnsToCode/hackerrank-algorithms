// https://www.hackerrank.com/challenges/library-fine/problem

package implimentation;

import java.util.Date;
import java.util.Scanner;

public class LibraryFine {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Date returnDate = getDate();
        Date dueDate = getDate();
        System.out.println(fine(returnDate, dueDate));
    }

    private static int fine(Date returnDate, Date dueDate) {
        if (returnDate.compareTo(dueDate) <= 0) {
            return 0;
        } else if (returnDate.getYear() == dueDate.getYear() && returnDate.getMonth() == dueDate.getMonth()) {
            return 15 * (returnDate.getDate() - dueDate.getDate());
        } else if (returnDate.getYear() == dueDate.getYear()) {
            return 500 * (returnDate.getMonth() - dueDate.getMonth());
        }
        return 10_000;
    }

    private static Date getDate() {
        int date = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        return new Date(year, month - 1, date);
    }
}
