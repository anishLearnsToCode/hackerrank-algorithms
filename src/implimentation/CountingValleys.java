// https://www.hackerrank.com/challenges/counting-valleys/problem

package implimentation;

import java.util.Scanner;

public class CountingValleys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        String terrain = scanner.next();
        System.out.println(numberOfValleys(terrain));
    }

    private static int numberOfValleys(String terrain) {
        int level = 0, valleys = 0;
        boolean checking = true;
        for (int index = 0 ; index < terrain.length() ; index++) {
            char character = terrain.charAt(index);
            level += character == 'D' ? -1 : 1 ;
            if (checking && level < 0) {
                valleys++;
                checking = false;
            } else if (level >= 0) {
                checking = true;
            }
        }
        return valleys;
    }
}
