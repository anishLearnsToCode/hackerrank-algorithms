// https://www.hackerrank.com/challenges/fair-rations/problem

package implimentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FairRations {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(minimumLoaves(array));
    }

    private static String minimumLoaves(int[] array) {
        int sum = Arrays.stream(array).sum();
        if (sum % 2 == 1) {
            return "NO";
        }

        List<Integer> oddIndices = getOddElements(array);
        int distributions = 0;
        for (int index = 0 ; index < oddIndices.size() ; index += 2) {
            distributions += oddIndices.get(index + 1) - oddIndices.get(index);
        }

        return String.valueOf(distributions * 2);
    }

    private static List<Integer> getOddElements(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int index = 0 ; index < array.length ; index++) {
            if (array[index] % 2 == 1) {
                list.add(index);
            }
        }
        return list;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
