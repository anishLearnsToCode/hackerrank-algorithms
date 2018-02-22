import java.util.Scanner;

public class TaumAndBirthday {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long black, white, costOfBlack, costOfWhite, conversionCost;

        System.out.print("Enter black items : ");
        black = s.nextLong();
        System.out.print("Enter White Items : ");
        white = s.nextLong();
        System.out.print("Enter black cost : ");
        costOfBlack = s.nextLong();
        System.out.print("Enter white cost : ");
        costOfWhite = s.nextLong();
        System.out.print("Conversion Cost : ");
        conversionCost = s.nextLong();

        long ans = result(black, costOfBlack, white, costOfWhite, conversionCost);
        System.out.println(ans);
    }

    public static long result(long black, long costOfBlack, long white, long costOfWhite, long conversionCost){
        long costOfBlack_final, costOfWhite_final;
        int i;

        if(costOfBlack > costOfWhite + conversionCost)
            costOfBlack_final = costOfWhite + conversionCost;
        else
            costOfBlack_final = costOfBlack;

        if(costOfWhite > costOfBlack + conversionCost)
            costOfWhite_final = costOfBlack + conversionCost;
        else
            costOfWhite_final = costOfWhite;

        return black*costOfBlack_final + white*costOfWhite_final;
    }
}
