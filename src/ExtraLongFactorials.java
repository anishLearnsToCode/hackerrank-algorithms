import java.util.Scanner;

public class ExtraLongFactorials {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        long ans;

        System.out.print("Enter Number : ");
        n=s.nextInt();

        ans = factorial(n);
        System.out.println(ans);
    }

    public static long factorial(int n){
        int i;
        long ans;

        for(i=1, ans=1 ; i<=n ; ans*=i, i++);

        return ans;
    }
}
