import java.util.Scanner;

public class StrangeCounter {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        long time, ans;

        time = s.nextLong();

        ans = strangeTime(time);
        System.out.println(ans);
    }

    public static long strangeTime(long time){
        long ans=0, exponent;
        int i;

        for(exponent = 3 ; ; exponent = 2*exponent + 3){
            if(time <= exponent){
                ans = 1 + (exponent - time);
                break;
            }
        }

        return ans;
    }
}
