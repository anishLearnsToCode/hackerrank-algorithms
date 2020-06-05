import java.util.Scanner;

public class test {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(-1 % 2);
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
