// https://www.hackerrank.com/challenges/weighted-uniform-string/problem

package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformStrings {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String string = scanner.next();
        int queries = scanner.nextInt();
        performQueries(string, queries);
    }

    private static void performQueries(String string, int queries) {
        Set<Integer> weights = getWeights(string);
        while (queries-- > 0) {
            int query = scanner.nextInt();
            System.out.println(weights.contains(query) ? "Yes" : "No");
        }
    }

    private static Set<Integer> getWeights(String string) {
        Set<Integer> weights = new HashSet<>();
        char current = string.charAt(0);
        weights.add(current - 96);
        for (int index = 1, value = current - 96 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (character == current) {
                value += current - 96;
                weights.add(value);
            } else {
                current = character;
                value = current - 96;
                weights.add(value);
            }
        }
        return weights;
    }
}
