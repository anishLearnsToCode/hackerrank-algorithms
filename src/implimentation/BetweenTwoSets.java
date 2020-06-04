// https://www.hackerrank.com/challenges/between-two-sets/problem

package implimentation;

import java.util.Iterator;
import java.util.Scanner;

public class BetweenTwoSets {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrimeNumbersSieve SIEVE = new PrimeNumbersSieve(100);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] factors = getArray(n);
        int[] multiples = getArray(m);
        System.out.println(totalPossibilities(factors, multiples));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int totalPossibilities(int[] first, int[] second) {
        int lcm = lcm(first);
        int gcd = gcd(second);
        return gcd % lcm == 0 ? 1 + factors(lcm, gcd) : 0 ;
    }

    private static int factors(int divisor, int dividend) {
        int count = 0;
        for (int number = 2 ; number * divisor <= dividend ; number++) {
            if (dividend % (divisor * number) == 0) {
                count++;
            }
        }
        return count;
    }

    private static int factorial(int number) {
        return number == 0 ? 1 : number * factorial(number - 1);
    }

    private static int lcm(int[] array) {
        int result = array[0];
        for (int index = 1 ; index < array.length ; index++) {
            result = lcm(result, array[index]);
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int[] array) {
        int result = array[0];
        for (int index = 1 ; index < array.length ; index++) {
            result = gcd(result, array[index]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int primeFactors(int number) {
        int count = 0;
        for (int primeNumber : SIEVE) {
            while (number != 1 && number % primeNumber == 0) {
                count++;
                number /= primeNumber;
            }
            if (number == 1) {
                break;
            }
        }

        return count;
    }

    private static class PrimeNumbersSieve implements Iterable<Integer> {
        private final int[] sieve;

        PrimeNumbersSieve(int size) {
            this.sieve = new int[size + 1];
            initializeSieve();
        }

        private void initializeSieve() {
            sieve[0] = 1;
            sieve[1] = 1;
            for (int number = 2 ; number * number <= sieve.length ; number++) {
                if (sieve[number] == 0) {
                    for (int j = number ; j * number < sieve.length ; j++) {
                        sieve[j * number] = 1;
                    }
                }
            }
        }

        @Override
        public Iterator<Integer> iterator() {
            return new SieveIterator(this.sieve);
        }

        private static class SieveIterator implements Iterator<Integer> {
            private Integer nextIndex = 2;
            private final int[] sieve;

            SieveIterator(int[] sieve) {
                this.sieve = sieve;
            }

            @Override
            public boolean hasNext() {
                return nextIndex != null;
            }

            @Override
            public Integer next() {
                int prime = nextIndex;
                for (int number = nextIndex + 1 ; number < sieve.length ; number++) {
                    if (sieve[number] == 0) {
                        nextIndex = number;
                        return prime;
                    }
                }
                nextIndex = null;
                return prime;
            }
        }
    }
}
