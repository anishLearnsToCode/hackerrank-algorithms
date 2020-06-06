// https://www.hackerrank.com/challenges/service-lane/problem

package implimentation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ServiceLane {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int queries = scanner.nextInt();
        int[] array = getArray(length);
        RangeQuery rangeQuery = new RangeQuery(array);
        while (queries-- > 0) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            System.out.println(rangeQuery.minInRange(start, end));
        }
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index]  = scanner.nextInt();
        }
        return array;
    }

    private static class RangeQuery {
        private final int[] array;
        private final int[][] distribution;

        RangeQuery(int[] array) {
            this.array = array;
            this.distribution = new int[3][array.length + 1];
            createDistributionData();
        }

        private void createDistributionData() {
            for (int index = 1 ; index < distribution[0].length ; index++) {
                for (int number = 0 ; number < 3 ; number++) {
                    distribution[number][index] = distribution[number][index - 1]
                            + (number == array[index - 1] - 1 ? 1 : 0) ;
                }
            }
        }

        public int minInRange(int start, int end) {
            Set<Integer> set = getElementsIn(start, end);
            return set.stream().min(Integer::compareTo).get();
        }

        private Set<Integer> getElementsIn(int start, int end) {
            Set<Integer> set = new HashSet<>();
            for (int number = 0 ; number < 3 ; number++) {
                if (distribution[number][end + 1] - distribution[number][start] > 0) {
                    set.add(number + 1);
                }
            }
            return set;
        }
    }
}
