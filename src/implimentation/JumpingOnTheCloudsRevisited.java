// https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem

package implimentation;

import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int jump = scanner.nextInt();
        int[] clouds = getArray(length);
        System.out.println(finalEnergy(clouds, jump));
    }

    private static int finalEnergy(int[] array, int jump) {
        int energy = 99;
        for (int index = jump % array.length ; index != 0 ; index = (index + jump) % array.length, energy--) {
            energy -= 2 * array[index];
        }
        return energy - 2 * array[0];
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++){
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
