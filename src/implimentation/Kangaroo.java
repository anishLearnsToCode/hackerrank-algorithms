// https://www.hackerrank.com/challenges/kangaroo/problem

package implimentation;

import java.util.Scanner;

public class Kangaroo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();
        System.out.println(willMeet(x1, v1, x2, v2) ? "YES" : "NO");
    }

    private static boolean willMeet(int x1, int v1, int x2, int v2) {
        int drift = v1 - v2;
        int delta = x2 - x1;
        if (drift == 0) {
            return delta == 0;
        }
        double time =  (double) delta / drift;
        return time >= 0 && (int) time == time ;
    }
}
