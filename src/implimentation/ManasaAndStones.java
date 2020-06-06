// https://www.hackerrank.com/challenges/manasa-and-stones/problem

package implimentation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ManasaAndStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int stones = scanner.nextInt();
            int step1 = scanner.nextInt();
            int step2 = scanner.nextInt();
            printLastStonePossibilities(stones, step1, step2);
        }
    }

    private static void printLastStonePossibilities(int stones, int a, int b) {
        Set<Integer> visited = new HashSet<>();
        int minStep = Math.min(a, b);
        int maxStep = Math.max(a, b);
        for (int index = 0 ; index < stones ; index++) {
            int value = minStep * (stones - index - 1) + maxStep * index;
            if (visited.contains(value)) {
                continue;
            }
            visited.add(value);
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
