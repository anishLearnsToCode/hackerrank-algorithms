// https://www.hackerrank.com/challenges/taum-and-bday/problem

package implimentation;

import java.util.Scanner;

public class TaumAndBirthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            long numberOfBlackGifts = scanner.nextLong();
            long numberOfWhiteGifts = scanner.nextLong();
            long costBlackGift = scanner.nextLong();
            long costWhiteGift = scanner.nextLong();
            long conversionCost = scanner.nextLong();
            System.out.println(minimumCost(numberOfBlackGifts, numberOfWhiteGifts,
                    costBlackGift, costWhiteGift, conversionCost)
            );
        }
    }

    private static long minimumCost(long blackGifts, long whiteGifts, long costBlack, long costWhite, long conversion) {
        long minimumBlackGiftCost = Math.min(costBlack, costWhite + conversion);
        long minimumWhiteGiftCost = Math.min(costWhite, costBlack + conversion);
        return blackGifts * minimumBlackGiftCost + whiteGifts * minimumWhiteGiftCost;
    }
}
