// https://www.hackerrank.com/challenges/chocolate-feast/problem

package implimentation;

import java.util.Scanner;

public class ChocolateFeast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int money = scanner.nextInt();
            int cost = scanner.nextInt();
            int tradeCost = scanner.nextInt();
            System.out.println(totalChocolates(money, cost, tradeCost));
        }
    }

    private static  int totalChocolates(int money, int cost, int tradeCost) {
        int chocolates = money / cost;
        int wrappers = chocolates;
        while (wrappers / tradeCost >= 1) {
            chocolates += wrappers / tradeCost;
            wrappers -= (wrappers / tradeCost) * (tradeCost - 1);
        }
        return chocolates;
    }
}
