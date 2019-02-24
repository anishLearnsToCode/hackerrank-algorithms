import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pairs {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = scanner.nextInt();
        int number = scanner.nextInt();
        long[] array = new long[size];

        input(array);
        System.out.println(possiblePairs(array, number));
    }

    private static void input(long[] array) {
        for(int index=0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
    }

    private static int possiblePairs(long[] array, int number) {
        HashSet<Long> numberEntries = getSet(array);
        HashSet<Pair<Long, Long>> usedNumbers = new HashSet<>(array.length);

        int possiblePairs = 0;

        for (long element : array) {
            possiblePairs += element - number < 0 ? 0 : numberOfPairs(array, element, element - number, usedNumbers, numberEntries);
            possiblePairs += numberOfPairs(array, element, element + number, usedNumbers, numberEntries);
        }

        return possiblePairs / 2;
    }

    private static int numberOfPairs(long[] array, long element, long number, HashSet<Pair<Long, Long>> usedNumbers, HashSet<Long> allNumbers) {
        if (allNumbers.contains(number) && !usedNumbers.contains(new Pair<>(element, number))) {
            usedNumbers.add(new Pair<>(element, number));
            return 1;
        }
        return 0;
    }

    private static HashSet<Long> getSet(long[] array) {
        HashSet<Long> set = new HashSet<>();
        for(long element : array) {
            set.add(element);
        }
        return set;
    }
}
