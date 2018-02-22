import java.util.Scanner;

public class ChocolateFeast {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int money, cost, wrapper, ans, i;

        System.out.print("Money : ");
        money = s.nextInt();
        System.out.print("Cost : ");
        cost = s.nextInt();
        System.out.print("Wrappers : ");
        wrapper = s.nextInt();

        ans = shop(money, cost, wrapper);
        System.out.println(ans);
    }

    public static int shop(int money, int cost, int wrapper){
        int ans;

        ans = money/cost;
        ans += exchangeSum(ans,  wrapper);
        return ans;
    }

    public static int exchangeSum(int currentWrapper, int wrapper){
        if(currentWrapper < wrapper){
           return 0;
        }

        return currentWrapper/wrapper + exchangeSum(currentWrapper/wrapper + currentWrapper%wrapper, wrapper);
    }
}
