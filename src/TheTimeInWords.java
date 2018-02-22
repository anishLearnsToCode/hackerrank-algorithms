import java.util.Scanner;
import java.util.SplittableRandom;

public class TheTimeInWords {
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int hour, minute;
        String ans;

        System.out.print("Hours : ");
        hour = s.nextInt();
        System.out.print("Minute : ");
        minute = s.nextInt();

        ans = timeInWords(hour, minute);
        System.out.println(ans);
    }

    public static String timeInWords(int hour, int minute){
        String ans="";

        if(minute == 0){
            ans = word(hour) + " o' clock";
        }
        else if(minute == 15){
            ans = "quarter past "+word(hour);
        }
        else if(minute < 30){
            ans = minute_word(minute)+" past "+word(hour);
        }else if(minute == 30){
            ans = "half past "+word(hour);
        }else if(minute > 30){
            ans = minute_word(60 - minute) + " to " + word(hour + 1);
        }

        return ans;
    }

    public static String minute_word(int n){
        String ans[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen"};
        String tens[] = {"twenty", "thirty", "forty", "fifty"};
        String ans2 = "";

        if(n < 20){
            ans2 = ans[n-1];
        }
        else{
            ans2 = tens[n/10-2];
            if(n%10 > 0){
                ans2 = ans2 + " " + ans[n%10 - 1];
            }
        }

        if(n==15 || n==30){
            ans2 = ans2;
        }
        else if(n==1){
            ans2 = ans2 + " minute";
        }else{
            ans2 = ans2 + " minutes";
        }

        return ans2;
    }

    public static String word(int n){
        String ans[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        return ans[n-1];
    }
}
