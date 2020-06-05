// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

package implimentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ClimbingTheLeaderboard {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] scores = getArray(scanner.nextInt());
        int[] games = getArray(scanner.nextInt());
        printRanksForEachGame(scores, games);
    }

    private static void  printRanksForEachGame(int[] scores, int[] games) {
        scores = getUniqueArray(scores);
        for (int game : games) {
            int smallerOrEqualIndex = search(scores, game);
            System.out.println(smallerOrEqualIndex + 1);
        }
    }

    private static int search(int[] array, int element) {
        int middle = array.length / 2;
        for (int start = 0, end = array.length ; start <= end && middle >= 0 && middle < array.length ; middle = (start + end) / 2) {
            if (array[middle] == element) {
                return middle;
            } else if (array[middle] < element) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        if (isInRange(middle - 1, array) && array[middle - 1] < element) {
            return middle - 1;
        } else if (isInRange(middle, array) && array[middle] < element) {
            return middle;
        } else if (isInRange(middle + 1, array) && array[middle + 1] < element) {
            return middle + 1;
        }
        return middle;
    }

    private static boolean isInRange(int index, int[] array) {
        return index >= 0 && index < array.length ;
    }

    private static int[] getUniqueArray(int[] array) {
        List<Integer> temp = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>();
        for (int number : array) {
            if (numbers.contains(number)) {
                continue;
            }
            numbers.add(number);
            temp.add(number);
        }
        return toArray(temp);
    }
    private static int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int index = 0 ; index < list.size() ; index++) {
            array[index] = list.get(index);
        }
        return array;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
