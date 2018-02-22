import java.util.Scanner;

public class SaveThePrisoner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int prisoners, candies, start, ans;

        prisoners = s.nextInt();
        candies = s.nextInt();
        start = s.nextInt();

        ans = result(prisoners, candies, start);
        System.out.println(ans);
        System.out.println(prisoner(prisoners, candies, start));
        System.out.println(prison(prisoners, candies, start));
    }

    public static int result(int prisoners, int candies, int start){
        if(candies==1){
            return start;
        }

        if(start==prisoners){
            return result(prisoners, candies-1, 1);
        }

        return result(prisoners, candies-1, start+1);
    }

    public static int prisoner(int prisoners, int candies, int start){
        int ans = start+candies-1;

        for( ; ; ){
            if(ans>prisoners){
                ans-=prisoners;
            }
            else
                break;
        }

        return ans;
    }

    public static int prison(int prisoners, int candies, int start){
        int ans = start + candies -1;

        if(ans%prisoners==0){
            ans = prisoners;
        }

        else if(ans>prisoners){
            ans = ans - prisoners*(ans / prisoners);
        }

        return ans;
    }
}
