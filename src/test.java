import java.util.Scanner;

public class test {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double time = scanner.nextDouble();
        double d = Math.log10(time / 3 + 1) / Math.log10(2);
        System.out.println(d);
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
