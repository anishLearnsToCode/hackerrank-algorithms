// https://www.hackerrank.com/challenges/halloween-sale/problem

package implimentation;

import java.util.Scanner;

public class HalloweenSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingPrice = scanner.nextInt();
        int difference = scanner.nextInt();
        int threshold = scanner.nextInt();
        int money = scanner.nextInt();
        System.out.println(maximumGames(startingPrice, difference, threshold, money));
    }

    private static int maximumGames(int start, int difference, int threshold, int money) {
        int games = 1 + (start - threshold) / difference;
        int spent = games * (2 * start - (games - 1) * difference) / 2;

        if (money >= spent) {
            return games + (money - spent) / threshold;
        }

        int b = 2 * start + difference;
        return (int) ((b - Math.sqrt(b * b - 8 * difference * money)) / (2 * difference));
    }
}
