package implimentation;

import java.util.Scanner;

public class TheTimeInWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        System.out.println(timeInWords(hour, minute));
    }

    public static String timeInWords(int hour, int minutes) {
        if (minutes == 0) {
            return word(hour) + " o' clock";
        } else if (minutes == 15) {
            return "quarter past " + word(hour);
        } else if (minutes < 30){
            return toWords(minutes) + " past " + word(hour);
        } else if(minutes == 30) {
            return "half past " + word(hour);
        }

        return toWords(60 - minutes) + " to " + word(hour + 1);
    }

    public static String toWords (int minutes) {
        String[] digits = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen"
        };
        String[] tens = {"twenty", "thirty", "forty", "fifty"};
        StringBuilder result = new StringBuilder();

        if (minutes < 20) {
            result.append(digits[minutes-1]);
        } else {
            result.append(tens[minutes/10-2]);
            if (minutes % 10 > 0){
                result.append(" ").append(digits[minutes%10 - 1]);
            }
        }

        if (minutes==15 || minutes==30){
            return result.toString();
        }

        return result.append(minutes == 1 ? " minute" : " minutes").toString();
    }

    public static String word(int hour){
        String[] ans = {
                "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve"
        };
        return ans[hour - 1];
    }
}
