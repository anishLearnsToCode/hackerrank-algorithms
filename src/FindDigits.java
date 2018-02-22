import java.util.Scanner;

public class FindDigits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number, ans;

        System.out.print("Number : ");
        number = s.nextInt();

        ans = even_divisors(number);
        System.out.println(ans);
    }

    public static int even_divisors(int n){
        int i, c;

        for(i=0, c=0 ; i<intlen(n) ; i++){
            if(digit(i, n)==0)
                continue;

            System.out.println(digit(i, n));

            if(n%digit(i, n) == 0){
                c++;
            }
        }

        return c;
    }

    public static int intlen(int n){
        int i;
        for(i=0 ; n!=0 ; n/=10, i++);
        return i;
    }

    public static int digit(int i, int n){
        int j = n/(int)Math.pow(10, intlen(n)-1-i);
        return j%10;
    }
}
