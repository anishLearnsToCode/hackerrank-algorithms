import java.util.Scanner;

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        long low, high, i;

        low = s.nextLong();
        high = s.nextLong();

        kaprekar(low, high);

        //for(i=low ; i<= high ; i++){
        //    System.out.println(num(0, intlen(i)/2, i));
        //}
    }

    public static void kaprekar(long low, long high){
        long i;
        boolean flag;

        for(i=low, flag = true ; i<=high ; i++){
            if(is_kaprekar(i)){
                System.out.print(i+" ");
                flag = false;
            }
        }

        if(flag)
            System.out.println("Invalid Range");
    }

    public static boolean is_kaprekar(long n){
        boolean ans;
        long number_new = (long)Math.pow(n, 2);

        if( num(0, intlen(number_new)/2, number_new) + num(intlen(number_new)/2, intlen(number_new), number_new) == n){
            ans = true;
        }
        else
            ans = false;

        return ans;
    }

    public static int intlen(long n){
        int i;
        for(i=0 ; n!=0 ; n/=10, i++);
        return i;
    }

    public static long num(int startIndex, int endIndex, long number){
        long ans;

        if(startIndex==0){
            ans = number/(long)Math.pow(10, intlen(number)-endIndex);
        }
        else{
            ans = number%(long)Math.pow(10, endIndex - startIndex);
        }

        return ans;
    }
}
