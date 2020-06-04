// https://www.hackerrank.com/challenges/compare-the-triplets/problem

package warmup;

import java.util.Arrays;
import java.util.Scanner;

public class CompareTheTriplets {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Score alice = getScore();
        Score bob = getScore();
        int[] result = alice.compareWith(bob);
        System.out.println(result[0] + " " + result[1]);
    }

    private static Score getScore() {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        return new Score(a, b, c);
    }

    private static class Score {
        int[] array = new int[3];

        Score(int a, int b, int c) {
            array[0] = a;
            array[1] = b;
            array[2] = c;
        }

        int[] compareWith(Score score) {
            int me = 0;
            int other = 0;
            for (int index = 0 ; index < 3 ; index++) {
                if (array[index] > score.array[index]) {
                    me++;
                } else if (array[index] < score.array[index]) {
                    other++;
                }
            }
            return new int[] {me, other};
        }
    }
}
