// https://www.hackerrank.com/challenges/strange-code/problem

package implimentation;

import java.util.Scanner;

public class StrangeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();
        System.out.println(seconds(time));
    }

    private static long seconds(long time) {
        long block = getBlock(time);
        long index = time - sum(block - 1);
        return (long) (3 * Math.pow(2, block - 1) - index + 1);
    }

    private static long sum(long block) {
        return (long) (3 * (Math.pow(2, block) - 1));
    }

    private static long getBlock(double time) {
        return (long) Math.ceil(Math.log10(time / 3 + 1) / Math.log10(2));
    }
}
