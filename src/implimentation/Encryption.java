// https://www.hackerrank.com/challenges/encryption/problem

package implimentation;

import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(encrypted(string));
    }

    private static String encrypted(String string) {
        String message = String.join("", string.split(" "));
        double key = Math.sqrt(message.length());
        int rows = (int) key;
        int columns = (int) Math.ceil(key);
        rows += rows * columns < message.length() ? 1 : 0 ;

        StringBuilder encrypted = new StringBuilder();
        for (int column = 0; column < columns ; column++) {
            for (int row = 0 ; row < rows && row * columns + column < message.length() ; row++) {
                encrypted.append(message.charAt(row * columns + column));
            }
            encrypted.append(" ");
        }

        return encrypted.toString();
    }
}
