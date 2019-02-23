import java.math.BigInteger;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/extra-long-factorials/problem?h_r=next-challenge&h_v=zen
public class ExtraLongFactorials {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n;
//        long ans;

        System.out.print("Enter Number : ");
        n=s.nextLong();

//        ans = factorial(n);
//        System.out.println(ans);

        extraLongFactorials(n);
    }

    public static long factorial(long n){
        int i;
        long ans;

        for(i=1, ans=1 ; i<=n ; ans*=i, i++);

        return ans;
    }

    static void extraLongFactorials(long n) {
        BigInteger integer = BigInteger.ONE;
        while (n > 1) {
            integer = integer.multiply(BigInteger.valueOf(n--));
        }
        System.out.println(integer);
    }
}