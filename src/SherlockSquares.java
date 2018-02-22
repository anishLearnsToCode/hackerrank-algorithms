import java.util.Scanner;

public class SherlockSquares {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i, a, b, ans;

        a = s.nextInt();
        b = s.nextInt();

        ans = squareNumbers(a, b);
        System.out.println(ans);
        System.out.println(square(a, b));
    }

    public static int squareNumbers(int a, int b){
        int i, c;

        for(i=a, c=0 ; i<=b ; i++){
            if(is_square(i)){
                c++;
            }
        }

        return c;
    }

    public static boolean is_square(int n){
        boolean flag = false;
        int i;

        if((n==0) || (n==1))
            return true;

        for(i=2 ; i<=n/2 ; i++){
            if(Math.pow(i, 2)==n){
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static int square(int a, int b){
        int i, c, sqr;

        for(i=(int)Math.sqrt(a), c=0 ; i<=Math.sqrt(b) ; i++){
            sqr = (int)Math.pow(i, 2);

            if((sqr<=b) && (sqr>=a)){
                c++;
            }
        }

        return c;
    }
}
