// https://www.hackerrank.com/challenges/sock-merchant/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] socks = getArray(length);
        System.out.println(pairs(socks));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int pairs(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            result += entry.getValue() / 2;
        }
        return result;
    }

    private static Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : array) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
        }
        return frequencies;
    }
}
