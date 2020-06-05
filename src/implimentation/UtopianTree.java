// https://www.hackerrank.com/challenges/utopian-tree/problem

package implimentation;

import java.util.Scanner;

public class UtopianTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int cycles = scanner.nextInt();
            System.out.println(heightAfter(cycles));
        }
    }

    private static int heightAfter(int cycles) {
        int height = 1;
        for (int cycle = 1 ; cycle <= cycles ; cycle++) {
            height += cycle % 2 == 0 ? 1 : height;
        }
        return height;
    }
}
