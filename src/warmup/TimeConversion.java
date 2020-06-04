package warmup;

import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.next();
        System.out.println(to24Hour(time));
    }

    private static String to24Hour(String time) {
        String[] tokens = time.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2].substring(0, 2));
        String median = tokens[2].substring(2);
        if (isMidnight(hour, median)) {
            return timeString(0, minutes, seconds);
        } else if (isNoon(hour, median)) {
            return timeString(12, minutes, seconds);
        } else if (median.equals("PM")) {
            hour  = (hour + 12) % 24 ;
        }

        return timeString(hour, minutes, seconds);
    }

    private static boolean isMidnight(int hours, String median) {
        return hours == 12 && median.equals("AM");
    }

    private static boolean isNoon(int hours, String median) {
        return hours == 12 && median.equals("PM");
    }

    private static String timeString(int hours, int minutes, int seconds) {
        return format(hours) + ":" + format(minutes) + ":" + format(seconds);
    }

    private static String format(int string) {
        return string < 10 ? "0" + string : "" + string;
    }
}
