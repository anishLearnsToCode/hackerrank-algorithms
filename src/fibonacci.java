import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;

        n = s.nextInt();

        System.out.println(fib(n));
    }

    public static long fib(int n) {
        if ((n == 1) || (n == 0))
            return 1;

        return fib(n - 1) + fib(n - 2);
    }
}

/*
bhai entering code
code = code

 */
