import java.util.Scanner;

public class HalloweenSale {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int price = scanner.nextInt();
        int difference = scanner.nextInt();
        int lastVal = scanner.nextInt();
        int money = scanner.nextInt();

        System.out.println(gamesYouCanBuy(price, difference, lastVal, money));
    }

    private static int gamesYouCanBuy(int price, int difference, int lastPrice, int money) {
        if ( money < price) {
            return 0;
        }

        int games=0, chargeValue;

        while (money >= lastPrice) {
            chargeValue = price - (games * difference);
            if (chargeValue <= lastPrice) {
                break;
            }
            money -= chargeValue;
            games++;
        }

        games += money / lastPrice;
        return games;
    }
}
