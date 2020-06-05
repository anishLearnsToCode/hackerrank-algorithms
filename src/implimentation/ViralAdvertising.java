// https://www.hackerrank.com/challenges/strange-advertising/problem

package implimentation;

import java.util.Scanner;

public class ViralAdvertising {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        System.out.println(totalLikes(days));
    }

    private static int totalLikes(int days) {
        int shared = 5, likes = 2;
        for (int day = 2 ; day <= days ; day++) {
            shared = (shared / 2) * 3;
            likes += shared / 2;
        }
        return likes;
    }
}
