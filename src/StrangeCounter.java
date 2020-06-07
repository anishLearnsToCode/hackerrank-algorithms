import java.util.Scanner;

public class StrangeCounter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long time = s.nextLong();
        System.out.println(strangeTime(time));
    }

    public static long strangeTime(long time){
        long ans = 0;
        for(long exponent = 3 ; ; exponent = 2*exponent + 3){
            if(time <= exponent){
                ans = 1 + (exponent - time);
                break;
            }
        }

        return ans;
    }
}
