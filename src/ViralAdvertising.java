import java.util.Scanner;

public class ViralAdvertising {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, ans;

        n= s.nextInt();
        ans = total_people(n);
        System.out.println(ans);
    }

    public static int people(int n){
        if (n==1)
            return 2;

        return 3*people(n-1)/2;
    }

    public static int total_people(int n){
        int i, sum;

        for(i=1, sum=0 ; i<=n ; i++){
            sum += people(i);
        }

        return sum;
    }
}
