import java.util.Scanner;

public class BeautifulDays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ans, start, end, k;

        start = s.nextInt();
        end = s.nextInt();
        k = s.nextInt();

        ans = days(start, end, k);
        System.out.println(ans);

        System.out.println(reverse(start));
    }

    public static int days(int start, int end, int k){
        int i, j, c;

        for(i=start, c=0 ; i<=end ; i++){
            if(Math.abs(i-reverse(i))%k==0){
                c++;
            }
        }

        return c;
    }

    public static int reverse(int n){
        int i, sum;

        for(i=0, sum=0 ; i<intlen(n) ; i++){
            sum += digit(intlen(n)-i-1, n)*Math.pow(10, intlen(n) - i - 1);
        }

        return sum;
    }

    public static int intlen(int n){
        int i;

        for(i=0 ; n!=0 ; n/=10, i++);

        return  i;
    }

    public static int digit(int i, int n){
        int j =n/(int)Math.pow(10, intlen(n)-1-i);
        return j%10;
    }
}
