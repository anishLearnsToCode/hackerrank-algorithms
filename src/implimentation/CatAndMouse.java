// https://www.hackerrank.com/challenges/cats-and-a-mouse/problem

package implimentation;

import java.util.Scanner;

public class CatAndMouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int catAPosition = scanner.nextInt();
            int catBPosition = scanner.nextInt();
            int mousePosition = scanner.nextInt();
            System.out.println(catAndMouse(catAPosition, catBPosition, mousePosition));
        }
    }

    private static final String catAndMouse(int catAPosition, int catBPosition, int mouse) {
        int distanceCatA = Math.abs(catAPosition - mouse);
        int distanceCatB = Math.abs(catBPosition - mouse);
        if (distanceCatA < distanceCatB) {
            return "Cat A";
        } else if (distanceCatB < distanceCatA) {
            return "Cat B";
        }

        return "Mouse C";
    }
}
