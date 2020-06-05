// https://www.hackerrank.com/challenges/cut-the-sticks/problem

package implimentation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CutTheSticks {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        printSticks(array);
    }

    private static void printSticks(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        Queue<Integer> minHeap = getMinHeap(array);
        int sticks = array.length;
        while (sticks >= 1 && !minHeap.isEmpty()) {
            System.out.println(sticks);
            int element = minHeap.poll();
            sticks -= frequencies.get(element);
        }
    }

    private static Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : array) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
        }
        return frequencies;
    }

    private static Queue<Integer> getMinHeap(int[] array) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        for (int number : array) {
            if (visited.contains(number)) {
                continue;
            }
            visited.add(number);
            minHeap.add(number);
        }
        return minHeap;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
