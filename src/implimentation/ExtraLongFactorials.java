// https://www.hackerrank.com/challenges/extra-long-factorials/problem

package implimentation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(factorial(new BigInteger(number + "")));
    }

    private static BigInteger factorial(BigInteger number) {
        return number.equals(BigInteger.ONE) ?
            BigInteger.ONE :
            number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }
}
