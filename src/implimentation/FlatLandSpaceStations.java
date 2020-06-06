// https://www.hackerrank.com/challenges/flatland-space-stations/problem

package implimentation;

import java.util.Arrays;
import java.util.Scanner;

public class FlatLandSpaceStations {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cities = scanner.nextInt();
        int spaceStations = scanner.nextInt();
        int[] stations = getArray(spaceStations);
        System.out.println(maxDistance(stations, cities));
    }

    private static int maxDistance(int[] array, int cities) {
        int maxDistance = 0;
        Arrays.sort(array);
        for (int index = 0 ; index < array.length - 1 ; index++) {
            maxDistance = Math.max(maxDistance, (array[index + 1] - array[index]) / 2);
        }
        return max(maxDistance, array[0], cities - 1 - array[array.length - 1]);
    }

    private static int max(int... numbers) {
        int result = Integer.MIN_VALUE;
        for (int number : numbers) {
            result = Math.max(result, number);
        }
        return result;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
