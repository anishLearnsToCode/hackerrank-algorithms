// https://www.hackerrank.com/challenges/drawing-book/problem

package implimentation;

import java.util.Scanner;

public class DrawingBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pages = scanner.nextInt();
        int page = scanner.nextInt();
        System.out.println(minimumTurns(pages, page));
    }

    private static int minimumTurns(int pages, int page) {
        int turnsFromStart = page / 2;
        int turnsFromBack = pages / 2 - turnsFromStart;
        return Math.min(turnsFromStart, turnsFromBack);
    }
}
