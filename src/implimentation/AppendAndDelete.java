// https://www.hackerrank.com/challenges/append-and-delete/problem

package implimentation;

import java.util.Scanner;

public class AppendAndDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        int k = scanner.nextInt();
        System.out.println(canBeModified(first, second, k) ? "Yes" : "No");
    }

    private static boolean canBeModified(String first, String second, int k) {
        Info info = getChanges(first, second, k);
        int changes = info.changes;
        int commonLength = info.commonSequenceLength;
        if (k < changes) {
            return false;
        } else if ((k - changes) % 2 == 0) {
            return true;
        }
        return k - changes >= 2 * commonLength;
    }

    private static Info getChanges(String first, String second, int k) {
        for (int index = 0 ; index < first.length() && index < second.length() ; index++) {
            if (first.charAt(index) != second.charAt(index)) {
                return new Info(first.length() + second.length() - 2 * index, index);
            }
        }
        int commonSequenceLength = Math.min(first.length(), second.length());
        return new Info(first.length() + second.length() - 2 * commonSequenceLength, commonSequenceLength);
    }

    private static class Info {
        int changes;
        int commonSequenceLength;

        Info(int changes, int commonSequenceLength) {
            this.changes = changes;
            this.commonSequenceLength = commonSequenceLength;
        }
    }
}
